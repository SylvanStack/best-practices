package com.yuanstack.bp.core.advance.jdk8.cart;

/**
 * @author hansiyuan
 * @date 2022年03月28日 23:22
 */
public class SkuBooksCategoryPredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
    }
}
