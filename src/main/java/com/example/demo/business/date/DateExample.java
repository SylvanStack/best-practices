package com.example.demo.business.date;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: 日期初始化
 * @author: hansiyuan
 * @date: 2021/10/20 4:53 下午
 */
@Slf4j
public class DateExample {
    public static void main(String[] args) throws Exception {
        /*
         * 注意点：
         *   1. SimpleDateFormat 两个著名的坑
         *   2. 时区问题
         *   3. 初始化问题
         */
//        wrongDateInit();
//        dateZoneIssue();
//        newDateExample();
//        dateParseAndFormat();
        simpleDateFormatThreadWrong();
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
    public static void dateZoneIssue() throws ParseException {
        // 关于时区的两个认识
        System.out.println(new Date(0));
        System.out.println(TimeZone.getDefault().getID() + ":" + TimeZone.getDefault().getRawOffset() / 3600000);
        String stringDate = "2020-01-02 22:00:00";
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 默认时区解析时间表示
        Date date1 = inputFormat.parse(stringDate);
        System.out.println(date1 + ":" + date1.getTime());
        // 纽约时区解析时间表示
        inputFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date date2 = inputFormat.parse(stringDate);
        System.out.println(date2 + ":" + date2.getTime());
        // 同一Date
        Date date = inputFormat.parse(stringDate);
        // 默认时区格式化输出：
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss Z]").format(date));
        // 纽约时区格式化输出
        TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss Z]").format(date));
    }

    /**
     * jdk8 新日期类型例子
     */
    public static void newDateExample() {
        // 一个时间表示
        String stringDate = "2020-01-02 22:00:00";
        // 初始化三个时区
        ZoneId timeZoneShangHai = ZoneId.of("Asia/Shanghai");
        ZoneId timeZoneNewYork = ZoneId.of("America/New_York");
        ZoneId timeZoneJST = ZoneOffset.ofHours(9);
        // 格式化器
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime date = ZonedDateTime.of(LocalDateTime.parse(stringDate, dateTimeFormatter), timeZoneJST);
        // 使用DateTimeFormatter格式化时间，可以通过withZone方法直接设置格式化使用的时区
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        System.out.println(timeZoneShangHai.getId() + outputFormat.withZone(timeZoneShangHai).format(date));
        System.out.println(timeZoneNewYork.getId() + outputFormat.withZone(timeZoneNewYork).format(date));
        System.out.println(timeZoneJST.getId() + outputFormat.withZone(timeZoneJST).format(date));
    }

    /**
     * 日期的解析和格式化：错误格式 "YYYY-MM-dd" 正确格式
     */
    public static void dateParseAndFormat() {
        // FRANCE  法国
        Locale.setDefault(Locale.CHINESE);
        System.out.println("defaultLocale:" + Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.DECEMBER, 29, 0, 0, 0);
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("格式化: " + yyyy.format(calendar.getTime()));
        System.out.println("weekYear:" + calendar.getWeekYear());
        System.out.println("firstDayOfWeek:" + calendar.getFirstDayOfWeek());
        System.out.println("minimalDaysInFirstWeek:" + calendar.getMinimalDaysInFirstWeek());
    }

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

    /**
     * SimpleDateFormat 多线程错误
     */
    public static void simpleDateFormatThreadWrong() throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            //提交20个并发解析时间的任务到线程池，模拟并发环境
            threadPool.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        System.out.println(simpleDateFormat.parse("2020-01-01 11:12:13"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }


}
