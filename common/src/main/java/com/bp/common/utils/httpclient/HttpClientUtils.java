package com.bp.common.utils.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static com.bp.common.utils.httpclient.HttpClientFactory.getRequestConfig;
import static com.bp.common.utils.httpclient.HttpClientFactory.httpClient;

/**
 * @description: http请求工具类
 * @author: hansiyuan
 * @date: 2022/3/10 2:34 PM
 */
@Slf4j
public class HttpClientUtils {


    public static BaseHttpResponse doGet(String url) {
        return doGet(url, null, null, null, null);
    }

    public static BaseHttpResponse doGet(String url, Map<String, String> tokenMap) {
        return doGet(url, tokenMap, null, null, null);
    }

    public static BaseHttpResponse doGet(String url, Map<String, String> tokenMap, Integer connectTimeout, Integer requestTimeout, Integer socketTimeout) {
        CloseableHttpResponse response = null;
        try {
            // 创建httpGet远程连接实例
            HttpGet httpGet = new HttpGet(url);

            // 设置请求头信息，鉴权
            if (tokenMap != null && !tokenMap.isEmpty()) {
                tokenMap.keySet().forEach(key -> httpGet.setHeader(key, tokenMap.get(key)));
            }
            // 设置配置请求参数
            RequestConfig requestConfig = getRequestConfig(connectTimeout, requestTimeout, socketTimeout);
            // 为httpGet实例设置配置
            httpGet.setConfig(requestConfig);

            // 执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            return handlerResponse(response);
        } catch (IOException e) {
            log.error("调用HttpClientUtils.doGet()异常", e);
        } finally {
            // 关闭资源
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static BaseHttpResponse doGetWithEntity(String url, Map<String, String> tokenMap, String jsonBody, Integer connectTimeout, Integer requestTimeout, Integer socketTimeout) {
        CloseableHttpResponse response = null;
        try {
            // 创建httpGet远程连接实例
            HttpGetWithEntity httpGet = new HttpGetWithEntity(url);
            // 设置请求头信息，鉴权
            if (tokenMap != null && !tokenMap.isEmpty()) {
                tokenMap.keySet().forEach(key -> httpGet.setHeader(key, tokenMap.get(key)));
            }
            // 设置配置请求参数
            RequestConfig requestConfig = getRequestConfig(connectTimeout, requestTimeout, socketTimeout);
            // 为httpGet实例设置配置
            httpGet.setConfig(requestConfig);
            //JSON BODY 方式
            if (StringUtils.isNotBlank(jsonBody)) {
                StringEntity se = new StringEntity(jsonBody, StandardCharsets.UTF_8.toString());
                se.setContentType("text/json");
                se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                httpGet.setEntity(se);
            }
            // 执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            return handlerResponse(response);
        } catch (IOException e) {
            log.error("调用HttpClientUtils.doGetWithEntity()异常", e);
        } finally {
            // 关闭资源
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static BaseHttpResponse doPost(String url, Map<String, Object> paramMap,
                                          Map<String, String> headerMap, String jsonBody) {
        return doPost(url, paramMap, headerMap, jsonBody, null, null, null);
    }

    public static BaseHttpResponse doPost(String url, Map<String, Object> paramMap, Map<String, String> headerMap,
                                          String jsonBody, Integer connectTimeout, Integer requestTimeout, Integer socketTimeout) {
        CloseableHttpResponse httpResponse = null;
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = getRequestConfig(connectTimeout, requestTimeout, socketTimeout);
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        if (!headerMap.containsKey(HTTP.CONTENT_TYPE)) {
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        }
        //封装header
        if (headerMap != null && headerMap.size() > 0) {
            headerMap.keySet().forEach(key -> httpPost.addHeader(key, headerMap.get(key)));
        }
        try {
            //JSON BODY 方式
            if (StringUtils.isNotBlank(jsonBody)) {
                StringEntity se = new StringEntity(jsonBody, StandardCharsets.UTF_8.toString());
                se.setContentType("text/json");
                if (MapUtils.isNotEmpty(headerMap) && !headerMap.containsKey(HTTP.CONTENT_TYPE)) {
                    se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                }
                httpPost.setEntity(se);
            }

            // 封装post请求参数
            if (null != paramMap && paramMap.size() > 0) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                // 通过map集成entrySet方法获取entity
                Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();
                // 循环遍历，获取迭代器
                for (Map.Entry<String, Object> mapEntry : entrySet) {
                    if (mapEntry.getValue() != null) {
                        nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
                    }
                }
                // 为httpPost设置封装好的请求参数
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            httpResponse = httpClient.execute(httpPost);
            return handlerResponse(httpResponse);
        } catch (IOException e) {
            log.error("HttpClientUtils.doPost异常", e);
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static BaseHttpResponse doPatch(String url, Map<String, Object> paramMap, Map<String, String> headerMap,
                                           String jsonBody, Integer connectTimeout, Integer requestTimeout, Integer socketTimeout) {
        CloseableHttpResponse httpResponse = null;

        // 创建HttpPatch远程连接实例
        HttpPatch httpPatch = new HttpPatch(url);
        // 配置请求参数实例
        RequestConfig requestConfig = getRequestConfig(connectTimeout, requestTimeout, socketTimeout);
        // 为HttpPatch实例设置配置
        httpPatch.setConfig(requestConfig);

        // 设置请求头
        if (!headerMap.containsKey(HTTP.CONTENT_TYPE)) {
            httpPatch.addHeader(HTTP.CONTENT_TYPE, "application/json");
        }
        //封装header
        if (headerMap != null && headerMap.size() > 0) {
            headerMap.keySet().forEach(key -> httpPatch.addHeader(key, headerMap.get(key)));
        }

        try {
            //JSON BODY 方式
            if (StringUtils.isNotBlank(jsonBody)) {
                StringEntity se = new StringEntity(jsonBody, StandardCharsets.UTF_8.toString());
                se.setContentType("text/json");
                if (MapUtils.isNotEmpty(headerMap) && !headerMap.containsKey(HTTP.CONTENT_TYPE)) {
                    se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                }
                httpPatch.setEntity(se);
            }

            // 封装post请求参数
            if (null != paramMap && paramMap.size() > 0) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                // 通过map集成entrySet方法获取entity
                Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();
                // 循环遍历，获取迭代器
                for (Map.Entry<String, Object> mapEntry : entrySet) {
                    if (mapEntry.getValue() != null) {
                        nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
                    }
                }

                // 为httpPost设置封装好的请求参数
                try {
                    httpPatch.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            httpResponse = httpClient.execute(httpPatch);
            return handlerResponse(httpResponse);
        } catch (IOException e) {
            log.error("HttpClientUtils.doPost异常", e);
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static BaseHttpResponse doDelete(String url, Map<String, String> tokenMap) {
        CloseableHttpResponse response = null;

        try {
            // 创建httpGet远程连接实例
            HttpDelete httpDelete = new HttpDelete(url);

            // 设置请求头信息，鉴权
            if (tokenMap != null && !tokenMap.isEmpty()) {
                tokenMap.keySet().forEach(key -> httpDelete.setHeader(key, tokenMap.get(key)));
            }

            // 设置配置请求参数
            RequestConfig requestConfig = getRequestConfig(null, null, null);
            // 为httpDelete实例设置配置
            httpDelete.setConfig(requestConfig);
            // 执行httpDelete请求得到返回对象
            response = httpClient.execute(httpDelete);

            return handlerResponse(response);
        } catch (IOException e) {
            log.error("HttpClientUtils.doDelete异常", e);
        } finally {
            // 关闭资源
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }


    /**
     * 上传文件
     *
     * @param url
     * @param headerMap
     * @param httpFileDTO
     * @return
     */
    public static BaseHttpResponse fileUpload(String url, Map<String, String> headerMap, BaseHttpFile httpFileDTO) {
        CloseableHttpResponse httpResponse = null;

        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = getRequestConfig(null, null, null);
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);

        //封装header
        if (headerMap != null && headerMap.size() > 0) {
            headerMap.keySet().forEach(key -> httpPost.addHeader(key, headerMap.get(key)));
        }

        try {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            //绑定文件参数，传入文件流和contenttype，此处也可以继续添加其他formdata参数
            builder.addBinaryBody(httpFileDTO.getParamName(), httpFileDTO.getInputStream(), ContentType.MULTIPART_FORM_DATA,
                    httpFileDTO.getFileName());

            httpPost.setEntity(builder.build());

            httpResponse = httpClient.execute(httpPost);
            return handlerResponse(httpResponse);
        } catch (ClientProtocolException e) {
            log.error("HttpClientUtils.fileUpload异常", e);
        } catch (IOException e) {
            log.error("HttpClientUtils.fileUpload异常", e);
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    private static BaseHttpResponse handlerResponse(CloseableHttpResponse response) throws IOException {
        // 从响应对象中获取响应内容
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, "UTF-8");
        }

        BaseHttpResponse baseHttpResponse = new BaseHttpResponse();
        baseHttpResponse.setBody(result);
        baseHttpResponse.setHeaders(handlerHeaders(response.getAllHeaders()));
        baseHttpResponse.setCookies(handlerCookies(response.getAllHeaders()));
        baseHttpResponse.setStatus(response.getStatusLine().getStatusCode());

        EntityUtils.consume(response.getEntity());
        return baseHttpResponse;
    }

    private static Map<String, String> handlerHeaders(Header[] headers) {
        Map<String, String> headerMap = null;
        if (headers != null && headers.length > 0) {
            headerMap = new HashMap<>();
            for (Header header : headers) {
                headerMap.put(header.getName(), header.getValue());
            }
        }
        return headerMap;
    }

    private static Map<String, String> handlerCookies(Header[] headers) {
        Map<String, String> cookieMap = null;
        if (headers != null && headers.length > 0) {
            cookieMap = new HashMap<>();
            for (Header header : headers) {
                if ("Set-Cookie".equals(header.getName())) {
                    String cookieStr = header.getValue();
                    if (StringUtils.isNotBlank(cookieStr)) {
                        String[] array = cookieStr.split(";");
                        for (String param : array) {
                            String[] paramArray = param.split("=");
                            if (paramArray.length > 1) {
                                cookieMap.put(paramArray[0], paramArray[1]);
                            } else {
                                cookieMap.put(paramArray[0], "");
                            }
                        }
                    }
                    break;
                }
            }
        }
        return cookieMap;
    }
}
