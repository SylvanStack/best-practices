package com.bp.core.advance.jvm.bytecode;

/**
 * @description: 字节码：循环
 * @author: hansiyuan
 * @date: 2021/10/14 12:27 上午
 */
public class ForLoopTest {
    private static int[] numbers = {1, 6, 8};

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        for (int number : numbers) {
            ma.submit(number);
        }
        double avg = ma.gerAvg();
    }
}
