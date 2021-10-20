package com.example.demo.advance.jdk8.stream;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @description: 日期初始化
 * @author: hansiyuan
 * @date: 2021/10/20 4:53 下午
 */
@Slf4j
public class DateExample {
    public static void main(String[] args) throws ParseException {
//        wrongDateInit();
        dateZOneIssue();
    }

    /**
     * Date 错误的初始化
     */
    public static void wrongDateInit() {
        Date date = new Date(2019, 12, 31, 11, 12, 13);
        // 年应该是和 1900 的差值，月应该是从 0 到 11 而不是从 1 到 12
        Date date1 = new Date(2019 - 1900, 11, 31, 11, 12, 13);
        log.info("date:{}", date);
        log.info("date1:{}", date1);

        // 当有国际化需求时，需要使用 Calendar 类来初始化时间
        // 使用 Calendar 改造之后，初始化时年参数直接使用当前年即可，不过月需要注意是从 0 到 11。
        // 当然，你也可以直接使用 Calendar.DECEMBER 来初始化月份，更不容易犯错。
        // 为了说明时区的问题，我分别使用当前时区和纽约时区初始化了两次相同的日期：
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.DECEMBER, 31, 11, 12, 13);
        log.info("calendar:{}", calendar.getTime());
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        calendar2.set(2019, Calendar.DECEMBER, 31, 11, 12, 13);
        log.info("calendar2:{}", calendar2.getTime());
    }

    /**
     * 时间时区问题
     */
    public static void dateZOneIssue() throws ParseException {
        // 关于时区的两个认识
        System.out.println(new Date(0));
        System.out.println(TimeZone.getDefault().getID() + ":" + TimeZone.getDefault().getRawOffset() / 3600000);
        String stringDate = "2020-01-02 22:00:00";
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //默认时区解析时间表示
        Date date1 = inputFormat.parse(stringDate);
        System.out.println(date1 + ":" + date1.getTime());
        //纽约时区解析时间表示
        inputFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date date2 = inputFormat.parse(stringDate);
        System.out.println(date2 + ":" + date2.getTime());
    }
}
