package com.bp.core.advance.jdk8.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description: 行为参数化过程
 * @author: hansiyuan
 * @date: 2021/11/4 5:13 下午
 */
public class ActionToParams {
    public static void main(String... args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        // 需求一：选出绿色苹果（方法） (值参数化)
        // 需求二：根据颜色选苹果（color参数） (值参数化)
        // 需求三：根据多个逻辑选苹果：颜色、重量（多个参数） (值参数化)
        List<Apple> greenApples = filterApplesByColor(inventory, "green");
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory, "red");
        System.out.println(redApples);

        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
        System.out.println(greenApples2);

        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples);

        // 4. 抽象 (行为参数化)
        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        // 5. 使用匿名类 (行为参数化)
        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return "red".equals(a.getColor());
            }
        });
        System.out.println(redApples2);

        // 6. 使用Lambda表达式 (行为参数化)
        List<Apple> redApples3 = filter(inventory, a -> "red".equals(a.getColor()));

        // 7. 将List类型抽象化
    }

    /**
     * 将List类型抽象化
     *
     * @param list 集合
     * @param p    谓词条件
     * @param <T>  范型
     * @return 结果集
     */
    public static <T> List<T> filter2(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * 应对不断变化的需求：1.筛选绿苹果
     *
     * @param inventory 库存
     * @return 绿苹果集合
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 应对不断变化的需求：2. 根据颜色筛选苹果
     *
     * @param inventory 库存
     * @param color     颜色
     * @return 苹果集合
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 应对不断变化的需求：3. 对你能想到的每个属性做筛选(加多个逻辑)
     *
     * @param inventory 库存
     * @param weight    重量
     * @return 集合
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 4. 根据抽象条件筛选
     *
     * @param inventory 库存
     * @param p         谓词
     * @return 过滤后的集合
     */
    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Apple {
        private int weight = 0;
        private String color = "";
    }

    /**
     * 抽象：苹果谓词
     */
    interface ApplePredicate {
        boolean test(Apple a);
    }

    static class AppleWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    static class AppleColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "red".equals(apple.getColor())
                    && apple.getWeight() > 150;
        }
    }
}
