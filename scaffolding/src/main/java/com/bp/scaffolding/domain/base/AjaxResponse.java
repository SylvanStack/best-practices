package com.bp.scaffolding.domain.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 通用响应数据结构类
 * @author: hansiyuan
 * @date: 2022/2/28 6:55 PM
 */
@Data
@ApiModel(value = "通用响应数据结构类")
public class AjaxResponse {

    @ApiModelProperty(value = "请求是否处理成功")
    private boolean isok;
    @ApiModelProperty(value = "请求响应状态码", example = "200、400、500")
    private int code;
    @ApiModelProperty(value = "请求结果描述信息")
    private String message;
    @ApiModelProperty(value = "请求结果数据")
    private Object data;

    private AjaxResponse() {
    }

    /**
     * 请求成功的响应，不带查询数据（用于删除、修改、新增接口）
     */
    public static AjaxResponse success() {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        return ajaxResponse;
    }

    /**
     * 请求成功的响应，带有查询数据（用于数据查询接口）
     */
    public static AjaxResponse success(Object obj) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    /**
     * 请求成功的响应，带有查询数据（用于数据查询接口）
     */
    public static AjaxResponse success(Object obj, String message) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}