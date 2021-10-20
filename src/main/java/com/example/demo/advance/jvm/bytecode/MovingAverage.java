package com.example.demo.advance.jvm.bytecode;

/**
 * @description: 移动平均数：字节码四则运算
 * @author: hansiyuan
 * @date: 2021/10/13 11:53 下午
 */
public class MovingAverage {
    private int count = 0;
    private double sum = 0.0D;

    public void submit(double value) {
        this.count++;
        this.sum += value;
    }

    public double gerAvg() {
        if (0 == this.count) {
            return sum;
        }
        return this.sum / this.count;
    }
}
