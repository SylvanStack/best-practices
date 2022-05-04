package com.yuanstack.bp.common.exception.modelview;

/**
 * @author hansiyuan
 * @date 2022年03月27日 23:42
 */
public class ModelViewException extends RuntimeException{

    //将Exception 转换为ModelViewException
    public static ModelViewException transfer(Throwable cause) {
        return new ModelViewException(cause);
    }

    private ModelViewException(Throwable cause) {
        super(cause);
    }
}
