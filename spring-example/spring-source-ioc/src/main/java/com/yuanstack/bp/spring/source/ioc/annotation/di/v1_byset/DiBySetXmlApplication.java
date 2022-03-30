package com.yuanstack.bp.spring.source.ioc.annotation.di.v1_byset;

import com.yuanstack.bp.spring.source.ioc.annotation.di.common.DiCat;
import com.yuanstack.bp.spring.source.ioc.annotation.di.common.DiPerson;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:24
 */
public class DiBySetXmlApplication {
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("di/set.xml");
        DiPerson person = beanFactory.getBean(DiPerson.class);
        System.out.println(person);

        DiCat cat = beanFactory.getBean(DiCat.class);
        System.out.println(cat);
    }
}
