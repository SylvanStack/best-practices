package com.yuanstack.bp.spring.source.ioc.annotation.dl.v4_withanno;

import com.yuanstack.bp.spring.source.ioc.annotation.dl.common.DlColor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:39
 */
public class WithAnnoApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dl/withAnno.xml");
        Map<String, Object> beans = ctx.getBeansWithAnnotation(DlColor.class);
        beans.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean.toString());
        });
    }
}
