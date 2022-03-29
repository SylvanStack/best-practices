package com.yuanstack.bp.core.advance.jdk8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;

/**
 * @description: 自定义Adjuster：实现功能下一个工作日
 * @author: hansiyuan
 * @date: 2021/11/2 6:07 下午
 */
public class CustomAdjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        // 获取当前天在周的日子
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int toAddDay = 1;
        if (dayOfWeek == DayOfWeek.FRIDAY) {
            toAddDay = 3;
        } else if (dayOfWeek == DayOfWeek.SATURDAY) {
            toAddDay = 2;
        }
        return temporal.plus(toAddDay, ChronoUnit.DAYS);
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2021, 10, 29);
        System.out.println(localDate.with(new CustomAdjuster()));
        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
                temporal -> {
                    DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
                    int toAddDay = 1;
                    if (dayOfWeek == DayOfWeek.FRIDAY) {
                        toAddDay = 3;
                    } else if (dayOfWeek == DayOfWeek.SATURDAY) {
                        toAddDay = 2;
                    }
                    return temporal.plus(toAddDay, ChronoUnit.DAYS);
                }
        );
        System.out.println(localDate.with(nextWorkingDay));
    }
}
