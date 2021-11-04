package com.bp.core.jdk8.before.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @description: JDK之前日期类使用 JDK1.0
 * @author: hansiyuan
 * @date: 2021/11/2 10:24 上午
 */
public class DateExample {
    public static void main(String[] args) {
        DateExample dateExample = new DateExample();
        dateExample.init();

    }

    /**
     * 日期类初始化
     */
    private void init() {
        /*
         * 存在问题：
         *    1. 无法表示日期，只能以毫秒的精度表示时间
         *    2. 年份的起始选择是1900年，月份的起始从0开始(易用性和扩展性)
         *    3. 输出结果不直观
         *    4. Date和Calendar类都是可以变的
         */
        System.out.println(new Date());

        // 2014年3月18日 正确表示 年份：2014-1990  月份：2
        System.out.println(new Date(114, Calendar.MARCH,18));

        // 让人误导的toString()
        System.out.println(new Date().toString());
    }


}
