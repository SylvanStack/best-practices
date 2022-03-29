package com.yuanstack.bp.dubbo.demo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 响应DTO
 * @author: hansiyuan
 * @date: 2021/11/17 4:08 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = -6830050563194710778L;
    /**
     * 响应编码
     */
    private Integer statusNum;

    /**
     * 请求是否成功
     */
    private Boolean isOk;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;
}
