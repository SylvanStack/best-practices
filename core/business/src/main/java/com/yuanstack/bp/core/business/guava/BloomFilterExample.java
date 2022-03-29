package com.yuanstack.bp.core.business.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.PrimitiveSink;

/**
 * 布隆过滤器
 *
 * @author hansiyuan
 * @date 2022年03月28日 23:26
 */
public class BloomFilterExample {
    public static void main(String[] args) {
        // 创建布隆过滤器
        BloomFilter<Integer> bloomFilter = BloomFilter.create(

                // 将任意类型数据转换为Java基础类型，默认转换为byte数组
                (Integer from, PrimitiveSink primitiveSink) -> primitiveSink.putInt(from),
                // 预计插入的元素总数
                10000L,
                // 期望误判率(0.0 ~ 1.0)
                0.1
        );

        // 向布隆过滤器中添加元素
        for (int i = 0; i < 10000; i++) {
            bloomFilter.put(i);
        }

        // 检测给定元素是否 可能 存在在布隆过滤器中
        boolean might = bloomFilter.mightContain(66666);
        System.out.println("是否存在？" + might);
    }
}
