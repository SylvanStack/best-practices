package com.bp.scaffolding.common.expection;

/**
 * @description: ModelViewException异常
 * @author: hansiyuan
 * @date: 2022/3/4 3:26 PM
 */
public class ModelViewException extends RuntimeException {

    /**
     * 将Exception 转换为ModelViewException
     */
    public static ModelViewException transfer(Throwable cause) {
        return new ModelViewException(cause);
    }

    private ModelViewException(Throwable cause) {
        super(cause);
    }
}
