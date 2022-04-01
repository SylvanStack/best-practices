package com.yuanstack.bp.core.design.create.singleton.logger;

/**
 * @description: 日志使用场景二
 * @author: hansiyuan
 * @date: 2022/4/1 5:25 PM
 */
public class OrderController {
    private OriginLogger logger = new OriginLogger();
    public void create(OrderVo order){
        // ...省略业务逻辑代码...
        logger.log("Created an order: " + order.toString());
    }
}
