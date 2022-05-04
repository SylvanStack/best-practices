package com.yuanstack.bp.common.exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;

/**
 * @author hansiyuan
 * @date 2022年03月27日 23:41
 */
@Component
@ControllerAdvice(basePackages = "com.yuanstack.bp")
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    //在Controller响应数据之后，客户端接收数据之前调用此方法
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //如果响应结果是JSON数据类型
        if (mediaType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)) {
            if (body instanceof AjaxResponse) {
                AjaxResponse ajaxResponse = (AjaxResponse) body;
                serverHttpResponse.setStatusCode(HttpStatus.valueOf(
                        ajaxResponse.getCode()  //统一响应数据状态与HTTP状态码
                ));
                return body;
            } else if (body instanceof LinkedHashMap) {
                LinkedHashMap spingErrorMap = (LinkedHashMap) body;
                int status = (Integer) spingErrorMap.get("status");
                if (status >= 200 && status < 300) {  //Controller返回的LinkedHashMap
                    serverHttpResponse.setStatusCode(HttpStatus.OK);
                    return AjaxResponse.success(body);
                } else { //Spring异常返回的LinkedHashMap
                    serverHttpResponse.setStatusCode(HttpStatus.valueOf(status));
                    return body;
                }
            } else {
                serverHttpResponse.setStatusCode(HttpStatus.OK);
                return AjaxResponse.success(body);
            }

        }

        return body;
    }
}

