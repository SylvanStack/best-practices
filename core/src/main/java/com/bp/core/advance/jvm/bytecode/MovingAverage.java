package com.bp.core.advance.jvm.bytecode;


/**
 * @author hansiyuan
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
