package com.bp.core.algo.array;

/**
 * @description: 自动扩容数组
 * @author: hansiyuan
 * @date: 2021/10/12 5:45 下午
 */

public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        this.size = 0;
        this.data = (T[]) new Object[capacity];
    }

    public int getLength() {
        return this.data.length;
    }

    public void add(T value) {
        if (size >= data.length) {
            addCapacity();
        }
        data[size] = value;
        size++;
    }

    public void addCapacity() {
        T[] newData = (T[]) new Object[size * 2];
        System.arraycopy(data, 0, newData, 0, size);
        this.data = newData;
    }

    /**
     * 打印
     */
    private void printfData() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }


    public static void main(String[] args) {
        GenericArray<Integer> array = new GenericArray<>(2);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        System.out.println(array.getLength());
        array.printfData();
    }
}
