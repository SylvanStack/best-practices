package com.bp.core.advance.jdk8.date;

import java.time.*;
import java.util.TimeZone;

/**
 * @description: 时区的使用
 * @author: hansiyuan
 * @date: 2021/11/2 7:51 下午
 */
public class ZoneExample {
    public static void main(String[] args) {
        zoneDateTimeExample();
    }

    private static void zoneDateTimeExample() {
        System.out.println(ZoneId.of("Europe/Rome"));
        //新老时区转换
        System.out.println(TimeZone.getDefault().toZoneId());

        LocalDate date = LocalDate.of(1997, 4, 8);
        ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.of("Europe/Rome"));
        System.out.println(zonedDateTime);
        System.out.println(LocalDateTime.of(2021, 11, 11, 11, 11, 11).atZone(ZoneId.of("Europe/Rome")));

        Instant instant = Instant.now();
        System.out.println(instant.atZone(ZoneId.of("Europe/Rome")).toLocalDate());
        System.out.println(LocalDate.from(instant.atZone(ZoneOffset.ofHours(8))));
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).getEpochSecond());
        // 不推荐使用ZoneOffset，未考虑日光时
        System.out.println(LocalDateTime.ofInstant(instant,ZoneOffset.ofHours(8)));
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(LocalDateTime.ofInstant(instant,zoneId));

        // 多日历的了解
        // ThaiBuddhistDate、MinguoDate、JapaneseDate以及HijrahDate
    }
}
