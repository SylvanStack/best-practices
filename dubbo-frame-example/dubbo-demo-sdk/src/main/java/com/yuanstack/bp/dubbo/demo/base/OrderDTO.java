package com.yuanstack.bp.dubbo.demo.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 订单DTO
 * @author: hansiyuan
 * @date: 2021/11/18 10:01 上午
 */
@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 6021928803795502878L;
    private String id;
    private String orderNo;
}
