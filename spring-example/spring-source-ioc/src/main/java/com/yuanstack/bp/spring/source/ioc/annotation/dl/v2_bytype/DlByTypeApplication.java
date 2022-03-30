package com.yuanstack.bp.spring.source.ioc.annotation.dl.v2_bytype;

import com.yuanstack.bp.spring.source.ioc.annotation.dl.common.DlPerson;
import com.yuanstack.bp.spring.source.ioc.annotation.dl.v2_bytype.dao.ByTypeDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找-byType
 *
 * @author hansiyuan
 * @date 2022年03月30日 22:09
 */
public class DlByTypeApplication {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("dl/byType.xml");
        DlPerson person = factory.getBean(DlPerson.class);
        System.out.println(person);

        ByTypeDao demoDao = factory.getBean(ByTypeDao.class);
        System.out.println(demoDao.findAll());
    }
}
