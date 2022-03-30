package com.yuanstack.bp.spring.source.ioc.annotation.dl.v3_oftype;

import com.yuanstack.bp.spring.source.ioc.annotation.dl.v3_oftype.dao.OfTypeDemoDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:31
 */
public class OfTypeApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dl/ofType.xml");
        Map<String, OfTypeDemoDao> beans = ctx.getBeansOfType(OfTypeDemoDao.class);
        beans.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean.toString());
        });
    }
}
