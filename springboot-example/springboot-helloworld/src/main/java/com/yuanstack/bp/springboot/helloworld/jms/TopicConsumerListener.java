package com.yuanstack.bp.springboot.helloworld.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:37
 */
@Component
public class TopicConsumerListener {
    //topic模式的消费者
    @JmsListener(destination = "${spring.activemq.topic-name}", containerFactory = "topicListener")
    public void readActiveQueue(String message) {
        System.out.println("topic接受到：" + message);
    }
}
