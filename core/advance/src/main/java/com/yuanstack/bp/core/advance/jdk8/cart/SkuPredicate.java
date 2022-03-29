package com.yuanstack.bp.core.advance.jdk8.cart;

/**
 * Sku选择谓词接口
 *
 * @author hansiyuan
 * @date 2022年03月28日 23:24
 */
public interface SkuPredicate {

    /**
     * 选择判断标准
     *
     * @param sku
     * @return
     */
    boolean test(Sku sku);

}
