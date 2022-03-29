package com.yuanstack.bp.core.advance.jdk8.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hansiyuan
 * @date 2022年03月28日 23:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sku {
    // 编号
    private Integer skuId;
    // 商品名称
    private String skuName;
    // 单价
    private Double skuPrice;
    // 购买个数
    private Integer totalNum;
    // 总价
    private Double totalPrice;
    // 商品类型
    private Enum skuCategory;

}
