package com.yuanstack.bp.core.design.behavior.template.helloworld;

/**
 * @description: 具体实现2
 * @author: hansiyuan
 * @date: 2022/3/30 10:21 AM
 */
public class ConcreteTemplateExample2 extends AbstractTemplateExample {
    @Override
    protected void method1() {
        System.out.println("实现2-执行method1...");
    }

    @Override
    protected void method2() {
        System.out.println("实现2-执行method2...");
    }
}
