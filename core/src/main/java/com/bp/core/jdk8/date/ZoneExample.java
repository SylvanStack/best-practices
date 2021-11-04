package com.bp.core.jdk8.date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

/**
 * @description: 时区的使用
 * @author: hansiyuan
 * @date: 2021/11/2 7:51 下午
 */
public class ZoneExample {
    public static void main(String[] args) {
        System.out.println(ZoneId.of("Europe/Rome"));
        //新老时区转换
        System.out.println(TimeZone.getDefault().toZoneId());

        LocalDate date = LocalDate.of(1997, 4, 8);
        ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.of("Europe/Rome"));
        System.out.println(zonedDateTime);
    }
}
