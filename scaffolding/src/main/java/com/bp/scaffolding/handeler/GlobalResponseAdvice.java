package com.bp.scaffolding.handeler;

import com.bp.scaffolding.common.base.ResponseDTO;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @description: 响应结果处理
 * @author: hansiyuan
 * @date: 2022/3/4 3:10 PM
 */
@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        //如果响应结果是JSON数据类型
        if (mediaType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)) {
            if (body instanceof ResponseDTO) {
                ResponseDTO ajaxResponse = (ResponseDTO) body;
                //999 不是标准的HTTP状态码，特殊处理
                if (ajaxResponse.getCode() != 999) {
                    serverHttpResponse.setStatusCode(HttpStatus.valueOf(
                            ajaxResponse.getCode()
                    ));
                }
                return body;
            }
        }
        return body;
    }
}
