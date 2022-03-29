package com.yuanstack.bp.common.utils.httpclient;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @description: HTTP响应类
 * @author: hansiyuan
 * @date: 2022/3/10 2:33 PM
 */
@Data
public class BaseHttpResponse implements Serializable {
    private static final long serialVersionUID = 8516875047439997914L;
    private String body;

    private Map<String, String> headers;

    private Map<String, String> cookies;

    private Integer status;
}
