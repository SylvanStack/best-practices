package com.yuanstack.bp.core.design.behavior.template.callback;

/**
 * @description: 回调测试
 * @author: hansiyuan
 * @date: 2022/3/30 11:47 AM
 */
public class CallbackExampleMain {
    public static void main(String[] args){
        ConcreteCallbackExample b = new ConcreteCallbackExample();
        //回调对象
        b.process(() -> System.out.println("Call back me."));
    }
}
