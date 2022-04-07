package com.yuanstack.bp.springboot.common.errors.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * @description: MyContextStartedEventListener
 * @author: hansiyuan
 * @date: 2022/4/6 5:38 PM
 */
@Slf4j
@Component
public class MyContextStartedEventListener implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(final ContextStartedEvent event) {
        log.info("{} received: {}", this.toString(), event);
    }
}
