package com.yuanstack.bp.spring.source.ioc.annotation.di.common;

import lombok.Data;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:17
 */
@Data
public class DiCat {
    private String name;
    private DiPerson master;
}
