package com.bp.core.algo.array;

/**
 * @description: 仿ArrayList
 * @author: hansiyuan
 * @date: 2021/9/29 3:31 下午
 */
public class MyArrayList {

    /**
     * 容器
     */
    private final int[] data;

    /**
     * 当前容量
     */
    private int count = 0;

    /**
     * 定义数组的长度
     */
    private int length = 8;

    public MyArrayList() {
        this.data = new int[length];
    }

    public MyArrayList(int capacity) {
        this.data = new int[length];
        this.length = capacity;
    }

    /**
     * 新增元素
     *
     * @param value
     */
    public void add(int value) {
        // 边界条件
        if (this.count == length) {
            throw new ArrayIndexOutOfBoundsException("数组越界啦");
        }

        this.data[count] = value;
        count++;
    }

    public int get(int index) {
        // 边界条件
        if (this.count <= index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("数组越界啦");
        }
        return data[index];
    }

    public void del(int index) {
        // 边界条件
        if (this.count <= index) {
            throw new ArrayIndexOutOfBoundsException("数组越界啦");
        }

        // 数据搬移
        if (count - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, count - 1 - index);
        }
        count--;
    }

    public void upd(int index, int value) {
        // 边界条件
        if (this.count <= index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("数组越界啦");
        }

        this.data[index] = value;
    }


    /**
     * 打印
     */
    private void printfData() {
        for (int i = 0; i < this.count; i++) {
            System.out.println(data[i]);
        }
    }


    public static void main(String[] args) {
        /*
         * 需求：
         *   数据特性：相同、连续存储、下标索引
         *   实现增删改查
         */
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.del(1);
        myArrayList.upd(1, 4);
        myArrayList.printfData();
        System.out.println(myArrayList.get(1));
    }
}
