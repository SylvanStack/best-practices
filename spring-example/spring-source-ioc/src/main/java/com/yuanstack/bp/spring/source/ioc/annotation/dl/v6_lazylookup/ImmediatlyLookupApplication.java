package com.yuanstack.bp.spring.source.ioc.annotation.dl.v6_lazylookup;

import com.yuanstack.bp.spring.source.ioc.annotation.dl.common.DlCat;
import com.yuanstack.bp.spring.source.ioc.annotation.dl.common.DlDog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:52
 */
public class ImmediatlyLookupApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dl/lazyLookup.xml");
        DlCat cat = ctx.getBean(DlCat.class);
        System.out.println(cat);

//        Dog dog;
//        try {
//            dog = ctx.getBean(Dog.class);
//        } catch (NoSuchBeanDefinitionException e) {
//        	dog = new Dog();
//        }

        DlDog dog = ctx.containsBean("dog") ? (DlDog) ctx.getBean("dog") : new DlDog();

        System.out.println(dog);
    }
}
