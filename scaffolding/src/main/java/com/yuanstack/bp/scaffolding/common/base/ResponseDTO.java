package com.yuanstack.bp.scaffolding.common.base;

import com.yuanstack.bp.scaffolding.common.expection.BaseException;
import com.yuanstack.bp.scaffolding.common.expection.BaseExceptionType;
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
public class ResponseDTO {

    @ApiModelProperty(value = "请求是否处理成功")
    private Boolean success;
    @ApiModelProperty(value = "请求响应状态码", example = "200、400、500")
    private Integer code;
    @ApiModelProperty(value = "请求结果描述信息")
    private String message;
    @ApiModelProperty(value = "请求结果数据")
    private Object data;

    private ResponseDTO() {
    }

    /**
     * 请求成功的响应，不带查询数据（用于删除、修改、新增接口）
     */
    public static ResponseDTO success() {
        ResponseDTO ajaxResponse = new ResponseDTO();
        ajaxResponse.setSuccess(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        return ajaxResponse;
    }

    /**
     * 请求成功的响应，带有查询数据（用于数据查询接口）
     */
    public static ResponseDTO success(Object obj) {
        ResponseDTO ajaxResponse = new ResponseDTO();
        ajaxResponse.setSuccess(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    /**
     * 请求成功的响应，带有查询数据（用于数据查询接口）
     */
    public static ResponseDTO success(Object obj, String message) {
        ResponseDTO ajaxResponse = new ResponseDTO();
        ajaxResponse.setSuccess(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    /**
     * 请求出现异常时的响应数据封装
     */
    public static ResponseDTO error(BaseException e) {
        ResponseDTO resultBean = new ResponseDTO();
        resultBean.setSuccess(false);
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }

    /**
     * 请求出现异常时的响应数据封装
     */
    public static ResponseDTO error(BaseExceptionType baseExceptionType,
                                    String errorMessage) {
        ResponseDTO resultBean = new ResponseDTO();
        resultBean.setSuccess(false);
        resultBean.setCode(baseExceptionType.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }
}