package com.yuanstack.bp.spring.source.ioc.annotation.dl.v6_lazylookup;

import com.yuanstack.bp.spring.source.ioc.annotation.dl.common.DlCat;
import com.yuanstack.bp.spring.source.ioc.annotation.dl.common.DlDog;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:50
 */
public class LazyLookupApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dl/lazyLookup.xml");
        DlCat cat = ctx.getBean(DlCat.class);
        System.out.println(cat);
        // 下面的代码会报Bean没有定义 NoSuchBeanDefinitionException
        // Dog dog = ctx.getBean(Dog.class);
        // System.out.println(dog);

        // 这一行代码不会报错
        ObjectProvider<DlDog> dogProvider = ctx.getBeanProvider(DlDog.class);
        // 只有当执行getObject方法时才会检查是否存在，即实现了延迟查找
        System.out.println(dogProvider.getObject());

        // jdk8后ObjectProvider接口有了新的扩展：借助Supplier接口返回缺省创建
        DlDog defaultDog = dogProvider.getIfAvailable(DlDog::new);
        System.out.println(defaultDog);
        // 只有存在Bean时才会执行Consumer接口的方法
        dogProvider.ifAvailable(System.out::println);

    }
}
