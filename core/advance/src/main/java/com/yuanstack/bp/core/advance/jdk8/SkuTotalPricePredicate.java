package com.yuanstack.bp.core.advance.jdk8;

/**
 * 对Sku的总价是否超出2000作为判断标准
 *
 * @author hansiyuan
 * @date 2022年03月28日 23:24
 */
public class SkuTotalPricePredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice() > 2000;
    }
}
