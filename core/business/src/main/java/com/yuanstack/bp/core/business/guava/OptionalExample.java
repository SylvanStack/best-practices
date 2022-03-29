package com.yuanstack.bp.core.business.guava;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Optional使用方法
 *
 * @author hansiyuan
 * @date 2022年03月28日 23:34
 */
public class OptionalExample {
    public void test() {
        // 创建空的Optional对象
        Optional.empty();

        // 使用非null值创建Optional对象
        Optional.of("zhangxiaoxi");

        // 使用任意值创建Optional对象
        Optional<String> optional = Optional.ofNullable("zhangxiaoxi");

        // 判断是否引用缺失的方法(建议不直接使用)
        optional.isPresent();

        // 当optional引用存在时执行 类似的方法：map filter flatMap
        optional.ifPresent(System.out::println);

        // 当optional引用缺失时执行
        optional.orElse("引用缺失");
        optional.orElseGet(() -> {
            // 自定义引用缺失时的返回值
            return "自定义引用缺失";
        });
        optional.orElseThrow(() -> {
            throw new RuntimeException("引用缺失异常");
        });
    }

    public static void stream(List<String> list) {
        list.stream().forEach(System.out::println);

        List<String> list1 = Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .collect(Collectors.toList());

        System.out.println("-----------");
        list1.stream().forEach(System.out::println);

        System.out.println("------------");
        System.out.println(JSON.toJSONString(list1));

    }

    public static void main(String[] args) {
        stream(null);
    }
}
