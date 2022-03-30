package com.yuanstack.bp.spring.source.ioc.annotation.di.v1_byset;

import com.yuanstack.bp.spring.source.ioc.annotation.di.common.DiCat;
import com.yuanstack.bp.spring.source.ioc.annotation.di.common.DiPerson;
import com.yuanstack.bp.spring.source.ioc.annotation.di.v1_byset.config.DiBySetConfiguration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:20
 */
public class DiBySetAnnoApplication {
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DiBySetConfiguration.class);
        DiPerson person = (DiPerson) beanFactory.getBean("diPerson");
        System.out.println(person);

        DiCat cat = beanFactory.getBean(DiCat.class);
        System.out.println(cat);
    }
}
