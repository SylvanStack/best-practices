package com.yuanstack.bp.core.advance.jdk8.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 行为参数化
 * @author: hansiyuan
 * @date: 2021/11/4 5:13 下午
 */
public class ActionToParamsExample {
    public static void main(String... args) throws InterruptedException {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
        // 用Comparator来排序
        inventory.sort(Comparator.comparingInt(Apple::getWeight));

        // 用Runnable执行代码块
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();

        thread.join();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Apple {
        private int weight = 0;
        private String color = "";
    }
}
