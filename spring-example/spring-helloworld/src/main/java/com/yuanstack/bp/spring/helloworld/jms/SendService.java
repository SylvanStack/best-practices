package com.yuanstack.bp.spring.helloworld.jms;

import com.alibaba.fastjson.JSON;
import com.yuanstack.bp.spring.helloworld.spring01.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Message;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:18
 */
@Component
public class SendService {
    @Autowired
    JmsTemplate jmsTemplate;

    public void send(final Student user) {
        jmsTemplate.send("test.queue", new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(JSON.toJSONString(user));
            }
        });
    }
}
