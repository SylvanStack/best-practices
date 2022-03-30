package com.yuanstack.bp.core.design.behavior.observer.myenvntbus;

import lombok.Data;

/**
 * @description: EventBus测试消息
 * @author: hansiyuan
 * @date: 2022/3/30 10:02 AM
 */
@Data
public class MyEventBusMessage {
    private String msgBody;
    private String msgHeader;
}
