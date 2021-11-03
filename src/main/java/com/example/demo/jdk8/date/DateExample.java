package com.example.demo.jdk8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * @description: 日期使用
 * @author: hansiyuan
 * @date: 2021/11/2 5:42 下午
 */
public class DateExample {
    public static void main(String[] args) {
        DateExample example = new DateExample();
//        example.withAttribute();
//        example.useTemporalAdjuster();
        example.parse();
    }

    /**
     * 修改属性
     */
    public void withAttribute() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.withYear(2020));
        System.out.println(localDate.withMonth(12));
        System.out.println(localDate.withDayOfYear(1));
        System.out.println(localDate.with(ChronoField.MONTH_OF_YEAR, 10));
        System.out.println(localDate);
    }

    /**
     * 更加灵活的对日期做处理
     */
    public void useTemporalAdjuster() {
        LocalDate localDate = LocalDate.of(2021, 1, 1);
        System.out.println(localDate.with(nextOrSame(DayOfWeek.SUNDAY)));
        System.out.println(localDate.with(lastDayOfMonth()));
    }

    public void parse() {
        System.out.println(LocalDate.parse("20211111", DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(LocalDate.parse("2021-11-11", DateTimeFormatter.ISO_LOCAL_DATE));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String dateformat = LocalDate.now().format(dateTimeFormatter);
        System.out.println(dateformat);
        System.out.println(LocalDate.parse(dateformat, dateTimeFormatter));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. MMMM  yyyy", Locale.ITALIAN);
        String dateStr = LocalDate.of(2021, 11, 11).format(formatter);
        System.out.println(dateStr);
        System.out.println(LocalDate.parse(dateStr, formatter));

        DateTimeFormatter formatterBuilder = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral("  ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral("  ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.CHINESE);
        String dateStr1 = LocalDate.of(2021, 11, 11).format(formatterBuilder);
        System.out.println(dateStr1);
        System.out.println(LocalDate.parse(dateStr1, formatterBuilder));
    }
}
