package com.bp.core.advance.jdk8.date;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * JDK8: LocalDate、LocalTime、Instant、Duration和Period
 *
 * @description: JDK Date API 定义的了解
 * @author: hansiyuan
 * @date: 2021/11/2 10:05 上午
 */
public class DateDefine {

    public static void main(String[] args) {
        DateDefine localDate = new DateDefine();
//        localDate.localTimeInit();
//        localDate.localDateInit();
//        localDate.dateTimeDefaultParse();
//        localDate.localDateTimeInit();
//        localDate.instantUse();
//        localDate.defineDuration();
//        localDate.definePeriod();
        localDate.commonFunctionUse();
    }

    /**
     * LocalDate的初始化
     */
    public void localDateInit() {
        /*
         * LocalDate:
         *   1. 不可变对象,只提供了简单的日期，并不含当天的时间信息
         *   2. 只提供了简单的日期，并不含当天的时间信息
         */

        // 获取当天日期
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // 静态工厂方法of创建一个LocalDate实例
        LocalDate myBirthday = LocalDate.of(1997, 4, 8);
        int year = myBirthday.getYear();
        Month month = myBirthday.getMonth();
        int monthValue = myBirthday.getMonthValue();
        int day = myBirthday.getDayOfMonth();
        System.out.println(month);
        System.out.println(year + "-" + monthValue + "-" + day);

        // 获取其他信息
        System.out.println(myBirthday.getDayOfMonth());
        System.out.println(myBirthday.getDayOfWeek());
        System.out.println(myBirthday.lengthOfMonth());

        // 使用TemporalField读取LocalDate的值
        System.out.println(myBirthday.get(ChronoField.YEAR));
        System.out.println(myBirthday.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(myBirthday.get(ChronoField.DAY_OF_YEAR));
    }

    /**
     * LocalTime的初始化
     */
    public void localTimeInit() {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        // of静态工厂构建
        LocalTime time = LocalTime.of(14, 1, 15);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println(hour + ":" + minute + ":" + second);
    }

    /**
     * 日期和时间的默认解析
     */
    public void dateTimeDefaultParse() {
        // 默认解析格式 "yyyy-MM-dd" 其他格式无法解析 抛DateTimeParseException异常
        System.out.println(LocalDate.parse("2020-01-01"));
        // 默认解析格式 "HH:mm:ss" 其他格式无法解析 抛DateTimeParseException异常
        System.out.println(LocalTime.parse("13:01:01"));
    }

    /**
     * localDateTime初始化
     */
    public void localDateTimeInit() {
        // 获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // of工厂构建
        System.out.println(LocalDateTime.of(2021, 11, 1, 0, 0, 0));
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        System.out.println(LocalDateTime.of(LocalDate.of(2021, 11, 1), LocalTime.now()));
        System.out.println(LocalDate.of(2021, 11, 1).atTime(LocalTime.now()));
        // 拆分
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());
    }

    /**
     * 时间戳的使用
     */
    public void instantUse() {
        System.out.println(Instant.now());
        System.out.println(Instant.ofEpochSecond(1, 1_000_000));
        System.out.println(Instant.ofEpochSecond(1));
    }

    /**
     * 定义Duration
     * 获取两个时间段相差的时长(time级别)
     */
    public void defineDuration() {
        // 两个Temporal对象之间的duration
        // 两个LocalTimes对象、两个LocalDateTimes对象，或者两个Instant对象（LocalDate不好使）
        Duration duration = Duration.between(LocalTime.of(14, 0, 0), LocalTime.of(15, 0, 0));
        System.out.println(duration.getSeconds());

        Duration threeMinutes = Duration.ofMinutes(3);
        System.out.println(threeMinutes.getSeconds());
        System.out.println(Duration.ofDays(10).getSeconds());
    }

    /**
     * 以年、月或者日的方式对多个时间单位建模:Period
     * 获取两个时间段相差的时长（天级别）
     */
    public void definePeriod() {
        /*
         * Java 8 中有一个专门的类 Period 定义了日期间隔，通过 Period.between 得到了两个 LocalDate 的差，
         * 返回的是两个日期差几年零几月零几天。如果希望得知两个日期之间差几天，
         * 直接调用 Period 的 getDays() 方法得到的只是最后的“零几天”，而不是算总的间隔天数
         */
        Period period = Period.between(LocalDate.of(2021, 11, 1), LocalDate.of(2021, 11, 11));
        System.out.println(period.getDays());

        System.out.println(Period.ofDays(10).getDays());
        System.out.println(Period.ofWeeks(3).getDays());
        // 两年六个月零一天
        System.out.println(Period.of(2, 6, 1).getYears());
    }

    /**
     * 通用方法
     */
    public void commonFunctionUse() {
        // 创建两个时间点之间interval(间隔)
        System.out.println(Period.between(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 11, 11)));
        System.out.println(LocalDate.now().minusDays(1));
        System.out.println(LocalDate.now().plusDays(1));
        System.out.println(LocalDate.now().isBefore(LocalDate.now()));
        System.out.println(LocalDate.now().isAfter(LocalDate.now()));
        System.out.println(LocalDate.now().compareTo(LocalDate.now().plusDays(1)));
    }
}
