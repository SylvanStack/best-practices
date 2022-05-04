package com.yuanstack.bp.common.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;

import static com.yuanstack.bp.common.httpclient.HttpClientConstants.*;

/**
 * @description: HttpClientFactory
 * @author: hansiyuan
 * @date: 2022/3/10 2:58 PM
 */
@Slf4j
public class HttpClientFactory {
    public static final CloseableHttpClient httpClient;
    private static final PoolingHttpClientConnectionManager connectionManager;

    /**
     * keepAlive策略
     */
    private static final ConnectionKeepAliveStrategy myStrategy = (response, context) -> {
        HeaderElementIterator it = new BasicHeaderElementIterator
                (response.headerIterator(HTTP.CONN_KEEP_ALIVE));
        while (it.hasNext()) {
            HeaderElement he = it.nextElement();
            String param = he.getName();
            String value = he.getValue();
            if (value != null && "timeout".equalsIgnoreCase(param)) {
                return Long.parseLong(value) * 1000;
            }
        }

        return KEEP_ALIVE * 1000;//如果没有约定，则默认定义时长为60s
    };

    static {
        //连接池配置
        connectionManager = new PoolingHttpClientConnectionManager();
        //最大连接数
        connectionManager.setMaxTotal(MAX_TOTAL);
        //每个路由最大连接数
        connectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);

        ConnectionConfig connConfig = ConnectionConfig
                .custom()
                .setMessageConstraints(
                        MessageConstraints.custom().setMaxLineLength(MAX_LINE_LENGTH).build()).build();
        connectionManager.setDefaultConnectionConfig(connConfig);

        //创建定制http客户端
        httpClient = HttpClients.custom()
                .setKeepAliveStrategy(myStrategy)
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(getRequestConfig(null, null, null))
                .build();

        //启动定制清除过期连接
        new IdleConnectionMonitorThread(connectionManager).start();
    }

    public static RequestConfig getRequestConfig(Integer connectTimeout, Integer requestTimeout, Integer socketTimeout) {
        // 连接主机服务超时时间
        connectTimeout = (connectTimeout == null ? CONNECT_TIMEOUT : connectTimeout);
        // 连接请求超时时间
        requestTimeout = (requestTimeout == null ? REQUEST_TIMEOUT : requestTimeout);
        // 读取数据连接超时时间
        socketTimeout = (socketTimeout == null ? SOCKET_TIMEOUT : socketTimeout);

        return RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(requestTimeout)
                .setSocketTimeout(socketTimeout).build();
    }
}
