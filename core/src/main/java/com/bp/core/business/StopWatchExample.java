package com.bp.core.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.stream.IntStream;

/**
 * @description: StopWatch 性能测试
 * @author: hansiyuan
 * @date: 2021/10/19 11:13 上午
 */
@Slf4j
public class StopWatchExample {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("method1");
        for (int i = 0; i < 10000; i++) {
            new StopWatchExample();
        }
        stopWatch.stop();
        stopWatch.start("method2");
        IntStream.rangeClosed(0, 10000).forEach(i -> new StopWatchExample());
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }
}
