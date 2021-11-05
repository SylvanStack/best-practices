package com.bp.core.jdk8.lambda;

import com.google.common.collect.Lists;
import org.springframework.util.StopWatch;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @description: 函数式接口使用
 * @author: hansiyuan
 * @date: 2021/11/5 4:32 下午
 */
public class UseFunctionalInterface {
    public static void main(String[] args) throws IOException {
        // 自定义函数接口
        customFileReader();
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("VVV");
        list.add("BBB");
        list.add("FFF");
        // Predicate
        List<String> result = list.stream().filter(i -> !"FFF".equals(i)).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(result);

        // Consumer
        result.forEach(i -> System.out.println("哈哈哈：" + i));

        // Function<T, R>

        // IntPredicate 无装箱
        StopWatch stopWatch = new StopWatch("拆装箱");
        stopWatch.start("无装箱");
        IntPredicate predicate = (int value) -> value % 2 == 0;
        System.out.println(predicate.test(10000));
        stopWatch.stop();
        stopWatch.start("有装箱");
        Predicate<Integer> predicate1 = (Integer value) -> value % 2 == 1;
        System.out.println(predicate1.test(10000));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    private static void customFileReader() throws IOException {
        System.out.println(processFile(reader -> reader.readLine() + reader.readLine() + reader.readLine() + reader.readLine()));
        System.out.println(processFile(BufferedReader::readLine));
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/hansiyuan/MyCode/best-practices/core/src/main/java/com/bp/core/jdk8/lambda/LambdaOrigin.java"))) {
            return processor.process(reader);
        }
    }
}
