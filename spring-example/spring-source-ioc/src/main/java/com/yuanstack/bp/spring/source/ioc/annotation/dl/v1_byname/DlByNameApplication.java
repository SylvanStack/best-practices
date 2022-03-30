package com.yuanstack.bp.spring.source.ioc.annotation.dl.v1_byname;

import com.yuanstack.bp.spring.source.ioc.annotation.dl.common.DlPerson;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找-byName
 * @author hansiyuan
 * @date 2022年03月30日 22:02
 */
public class DlByNameApplication {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("dl/byName.xml");
        DlPerson person = (DlPerson) factory.getBean("dlPerson");
        System.out.println(person);
    }
}
