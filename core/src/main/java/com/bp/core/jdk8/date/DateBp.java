package com.bp.core.jdk8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;

/**
 * @description: 日期类最佳实践
 * @author: hansiyuan
 * @date: 2021/11/4 2:48 下午
 */
public class DateBp {

    public static void main(String[] args) {

        //一个时间表示
        String stringDate = "2020-01-02 22:00:00";
        //初始化三个时区
        ZoneId timeZoneSH = ZoneId.of("Asia/Shanghai");
        ZoneId timeZoneNY = ZoneId.of("America/New_York");
        ZoneId timeZoneJST = ZoneOffset.ofHours(9);
        //格式化器
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime date = ZonedDateTime.of(LocalDateTime.parse(stringDate, dateTimeFormatter), timeZoneJST);
        //使用DateTimeFormatter格式化时间，可以通过withZone方法直接设置格式化使用的时区
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        System.out.println(timeZoneSH.getId() + "  " + outputFormat.withZone(timeZoneSH).format(date));
        System.out.println(timeZoneNY.getId() + "  " + outputFormat.withZone(timeZoneNY).format(date));
        System.out.println(timeZoneJST.getId() + "  " + outputFormat.withZone(timeZoneJST).format(date));

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), timeZoneSH));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.plusDays(30));

        System.out.println("//测试操作日期");
        System.out.println(LocalDate.now()
                .minus(Period.ofDays(1))
                .plus(1, ChronoUnit.DAYS)
                .minusMonths(1)
                .plus(Period.ofMonths(1)));

        System.out.println("//本月的第一天");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));

        System.out.println("//今年的程序员日");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()).plusDays(255));

        System.out.println("//今天之前的一个周六");
        System.out.println(LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY)));

        System.out.println("//本月最后一个工作日");
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
        System.out.println(LocalDate.now().with(temporal -> temporal.plus(ThreadLocalRandom.current().nextInt(100), ChronoUnit.DAYS)));

        System.out.println(isFamilyBirthday(LocalDate.of(1997,5,22)));


        System.out.println("//查询是否是今天要举办生日");
        System.out.println(LocalDate.now().query(DateBp::isFamilyBirthday));


        System.out.println("//计算日期差");
        LocalDate today = LocalDate.of(2019, 12, 12);
        LocalDate specifyDate = LocalDate.of(2019, 10, 1);
        System.out.println(Period.between(specifyDate, today).getDays());
        System.out.println(Period.between(specifyDate, today));
        System.out.println(ChronoUnit.DAYS.between(specifyDate, today));
    }

    public static Boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(MONTH_OF_YEAR);
        int day = date.get(DAY_OF_MONTH);
        if (month == Month.FEBRUARY.getValue() && day == 17) {
            return Boolean.TRUE;
        }
        if (month == Month.SEPTEMBER.getValue() && day == 21) {
            return Boolean.TRUE;
        }
        if (month == Month.MAY.getValue() && day == 22) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
