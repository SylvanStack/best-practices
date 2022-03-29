package com.yuanstack.bp.core.advance.jdk8.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * @description: lambda的由来
 * @author: hansiyuan
 * @date: 2021/10/31 1:48 下午
 */
public class LambdaOrigin {
    public static void main(String... args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
//        sortCompare(inventory);
        lambdaExample(inventory);
    }

    /**
     * 排序对比
     *
     * @param inventory 库存
     */
    private static void sortCompare(List<Apple> inventory) {
        StopWatch stopWatch = new StopWatch("简单测试");
        //region JDK8之前排序+遍历
        stopWatch.start("before");
        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        for (Apple apple : inventory) {
            System.out.println(apple);
        }
        stopWatch.stop();
        //endregion

        //region lambda表达式排序
        stopWatch.start("lambda");
        inventory.sort(comparing(Apple::getWeight));
        inventory.forEach(System.out::println);
        stopWatch.stop();
        //endregion
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 从传递方法 到 lambda 表达式
     *
     * @param inventory 容量
     */
    private static void lambdaExample(List<Apple> inventory) {
        List<Apple> greenApples = filterApples(inventory, LambdaOrigin::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory, LambdaOrigin::isHeavyApple);
        System.out.println(heavyApples);

        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println(weirdApples);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Apple {
        private int weight = 0;
        private String color = "";
    }
}
