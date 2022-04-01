package com.yuanstack.bp.spring.helloworld.spring01;

import com.yuanstack.bp.spring.helloworld.aop.Klass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.junit.Assert;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:23
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Sprint01Test {

    @Autowired
    private Klass class1;

    @Test
    public void KlassTest() {
        Assert.assertEquals(2, class1.getStudents().size());
    }

    // 集成测试
}
