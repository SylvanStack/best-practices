package com.yuanstack.bp.core.advance.jdk8.date.before;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @description: JDK之前日期类使用 JDK1.0
 * 在 Java 8 之前，使用 Date、Calender 和 SimpleDateFormat，来声明时间戳、使用日历处理日期和格式化解析日期时间。
 * TimeZone 时区
 * @author: hansiyuan
 * @date: 2021/11/2 10:24 上午
 */
public class DateExample {
    public static void main(String[] args) throws ParseException {
        /*
         * Date 类：
         *      一是，Date 并无时区问题
         *      二是，Date 中保存的是一个时间戳
         */
//        DateExample dateExample = new DateExample();
//        dateExample.init();

        System.out.println(new Date(0));
        System.out.println(TimeZone.getDefault().getID() + ":" + TimeZone.getDefault().getRawOffset()/3600000);
        /*
         * 国际化的项目最佳实践
         *  - 以 UTC 保存(无需关注时区)
         *  - 以字面量保存（需要注意时区问题）
         */
        String stringDate = "2020-01-02 22:00:00";
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //同一Date
        Date date = inputFormat.parse(stringDate);
        //默认时区格式化输出：
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss Z]").format(date));
        //纽约时区格式化输出
        TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss Z]").format(date));
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
