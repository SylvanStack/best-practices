package com.bp.core.advance.concurrent.atomic;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:09
 */
public class Count {

    private int num = 0;

    public int add() {
        return num++;
    }

    public int getNum() {
        return num;
    }
}
