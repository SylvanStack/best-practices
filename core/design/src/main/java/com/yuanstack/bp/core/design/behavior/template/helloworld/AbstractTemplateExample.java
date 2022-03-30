package com.yuanstack.bp.core.design.behavior.template.helloworld;

/**
 * @description: 模版设计模式示例
 * @author: hansiyuan
 * @date: 2022/3/30 10:14 AM
 */
public abstract class AbstractTemplateExample {
    /**
     * 模版方法
     */
    public final void templateMethod() {
        //...
        method1();
        //...
        method2();
        //...
    }

    protected abstract void method1();

    protected abstract void method2();
}
