package com.yuanstack.bp.core.design.behavior.observer.myenvntbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @description: 自定义EventBus
 * @author: hansiyuan
 * @date: 2022/3/29 5:53 PM
 */
public class CustomEventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();
    public CustomEventBus(){
        this(MoreExecutors.directExecutor());
    }
    protected CustomEventBus(Executor executor){
        this.executor = executor;
    }
    public void register(Object object){
        registry.register(object);
    }
    public void post(Object event){
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(() -> observerAction.execute(event));
        }
    }
}
