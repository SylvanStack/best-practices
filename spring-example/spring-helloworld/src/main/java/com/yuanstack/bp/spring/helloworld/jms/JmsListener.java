package com.yuanstack.bp.spring.helloworld.jms;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:02
 */
@Component(value = "jmsListener")
public class JmsListener implements MessageListener {

    //收到信息时的动作
    @Override
    public void onMessage(Message m)  {
        ObjectMessage message = (ObjectMessage) m;
        try {
            System.out.println("收到的信息：" + message.getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
