package com.yuanstack.bp.common.utils.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

/**
 * @description: 增加存在body 的http GET请求
 * @author: hansiyuan
 * @date: 2022/3/10 3:32 PM
 */
@Slf4j
public class HttpGetWithEntity extends HttpEntityEnclosingRequestBase {

    public final static String METHOD_NAME = "GET";

    public HttpGetWithEntity(URI url) {
        super();
        this.setURI(url);
    }

    public HttpGetWithEntity(String url) {
        super();
        setURI(URI.create(url));
    }

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }
}
