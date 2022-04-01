package com.yuanstack.bp.spring.helloworld.aop;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:26
 */
public class AopTest {

    private Klass class1;

    @Test
    public void KlassTest() {
        class1 = mock(Klass.class, RETURNS_DEEP_STUBS);
        when(class1.getStudents().size()).thenReturn(2);
        Assert.assertEquals(2, class1.getStudents().size());
    }

    // 单元测试
}