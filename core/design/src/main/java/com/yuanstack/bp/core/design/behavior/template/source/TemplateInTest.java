package com.yuanstack.bp.core.design.behavior.template.source;

/**
 * @description: 模版模式在Java源码中的应用
 * @author: hansiyuan
 * @date: 2022/3/30 11:07 AM
 */
public class TemplateInTest {
    public static void main(String[] args) {
        // 模版模式在JUnitTest中的应用(复用)
        templateInJUnitTest();
    }

    private static void templateInJUnitTest() {
        // TestCase extends Assert abstractList;
        // 1、public abstract class TestCase extends Assert implements Test
        //  1.1、protected void setUp() throws Exception
        //  1.2、protected void tearDown() throws Exception
    }

}
