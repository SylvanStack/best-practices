package com.example.demo.jdk8.before.date;

/**
 * @description: Calendar示例 JDK1.1
 * @author: hansiyuan
 * @date: 2021/11/2 10:36 上午
 */
public class CalendarExample {
    public static void main(String[] args) {
        CalendarExample calendarExample = new CalendarExample();
        calendarExample.init();
    }

    /**
     * Calendar初始化
     */
    private void init() {
        /*
         * Calendar存在的问题：
         *   1. 月份依旧是从0开始计算
         *   2. 同时存在Date和Calendar这两个类，也增加了程序员的困惑。到底该使用哪一个类呢？
         *   3. 用于以语言无关方式格式化和解析日期或时间的DateFormat方法就只在Date类里有
         *   4. Date和Calendar类都是可以变的
         */
    }

    /**
     * DateFormat() 的使用
     */
    public void dateFormatUse() {
        /*
         * DateFormat()存在的问题：
         *   1. 不是线程安全的：两个线程如果尝试使用同一个formatter解析日期，你可能会得到无法预期的结果
         */

    }

}
