package com.yuanstack.bp.springboot.helloworld.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:37
 */
@Component
public class QueueConsumerListener {
    //queue模式的消费者
    @JmsListener(destination = "${spring.activemq.queue-name}", containerFactory = "queueListener")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }
}
