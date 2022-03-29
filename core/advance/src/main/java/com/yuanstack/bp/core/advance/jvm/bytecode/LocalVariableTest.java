package com.yuanstack.bp.core.advance.jvm.bytecode;


/**
 * @author hansiyuan
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
