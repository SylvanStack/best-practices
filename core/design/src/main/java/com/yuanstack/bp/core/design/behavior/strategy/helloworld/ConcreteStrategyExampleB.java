package com.yuanstack.bp.core.design.behavior.strategy.helloworld;

/**
 * @description: 策略B 策略的定义
 * @author: hansiyuan
 * @date: 2022/3/15 10:07 AM
 */
public class ConcreteStrategyExampleB implements StrategyExample{
    @Override
    public void algorithm(){
        //具体的算法...
        System.out.println("策略B执行算法...");
    }
}
