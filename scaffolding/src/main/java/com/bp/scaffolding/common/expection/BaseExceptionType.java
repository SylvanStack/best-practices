package com.bp.scaffolding.common.expection;

import lombok.Getter;

/**
 * @description: 异常类型
 * @author: hansiyuan
 * @date: 2022/3/4 2:39 PM
 */
@Getter
public enum BaseExceptionType {
    USER_INPUT_ERROR(400, "您输入的数据错误或您没有权限访问资源！"),
    SYSTEM_ERROR(500, "系统出现异常，请您稍后再试或联系管理员！"),
    OTHER_ERROR(999, "系统出现未知异常，请联系管理员！");

    BaseExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 异常类型中文描述
     */
    private String desc;

    /**
     * 异常状体code
     */
    private int code;
}
