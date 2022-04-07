package com.yuanstack.bp.springboot.common.errors.dao;

import com.yuanstack.bp.springboot.common.errors.core.dao.BpDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: 测试
 * @author: hansiyuan
 * @date: 2022/4/6 5:09 PM
 */
@SpringBootTest
public class BpDataSourceTest {
    @Autowired
    private BpDataSource jdbcBpDataSource;

    @Test
    public void test(){
        System.out.println(jdbcBpDataSource);
    }
}
