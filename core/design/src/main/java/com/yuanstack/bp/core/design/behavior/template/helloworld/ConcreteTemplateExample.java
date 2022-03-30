package com.yuanstack.bp.core.design.behavior.template.helloworld;

/**
 * @description: 模版的具体实现
 * @author: hansiyuan
 * @date: 2022/3/30 10:20 AM
 */
public class ConcreteTemplateExample extends AbstractTemplateExample {
    @Override
    protected void method1() {
        System.out.println("实现1-执行method1...");
    }

    @Override
    protected void method2() {
        System.out.println("实现1-执行method2...");
    }
}
