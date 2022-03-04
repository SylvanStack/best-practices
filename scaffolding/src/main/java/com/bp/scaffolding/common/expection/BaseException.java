package com.bp.scaffolding.common.expection;

/**
 * @description: 自定义异常
 * @author: hansiyuan
 * @date: 2022/3/4 2:41 PM
 */
public class BaseException extends RuntimeException {
    /**
     * 异常错误编码
     */
    private int code;

    /**
     * 异常信息
     */
    private String message;

    private BaseException() {
    }

    public BaseException(BaseExceptionType baseExceptionTypeEnum) {
        this.code = baseExceptionTypeEnum.getCode();
        this.message = baseExceptionTypeEnum.getDesc();
    }

    public BaseException(BaseExceptionType baseExceptionTypeEnum,
                         String message) {
        this.code = baseExceptionTypeEnum.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
