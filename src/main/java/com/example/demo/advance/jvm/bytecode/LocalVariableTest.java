package com.example.demo.advance.jvm.bytecode;

/**
 * @description: 四则运算字节码 测试类
 * @author: hansiyuan
 * @date: 2021/10/13 11:56 下午
 */
public class LocalVariableTest {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        ma.submit(num1);
        ma.submit(num2);
        double avg = ma.gerAvg();
    }
}
