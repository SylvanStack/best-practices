package com.yuanstack.bp.springboot.common.errors.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @description: MyContextRefreshedEventListener
 * @author: hansiyuan
 * @date: 2022/4/6 5:59 PM
 */
@Component
@Slf4j
public class MyContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("{} received: {}", this, event);
    }
}
