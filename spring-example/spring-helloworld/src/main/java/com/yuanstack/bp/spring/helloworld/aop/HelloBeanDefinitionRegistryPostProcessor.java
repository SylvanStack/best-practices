package com.yuanstack.bp.spring.helloworld.aop;

import com.yuanstack.bp.spring.helloworld.spring01.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:15
 */
@Component
public class HelloBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println(" ==> postProcessBeanDefinitionRegistry: "+registry.getBeanDefinitionCount());
        System.out.println(" ==> postProcessBeanDefinitionRegistry: "+String.join(",",registry.getBeanDefinitionNames()));
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Student.class);
        rootBeanDefinition.getPropertyValues().add("id", 101);
        rootBeanDefinition.getPropertyValues().add("name", "KK101");
        registry.registerBeanDefinition("s101", rootBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(" ==> postProcessBeanFactory: "+beanFactory.getBeanDefinitionCount());
        System.out.println(" ==> postProcessBeanFactory: "+String.join(",",beanFactory.getBeanDefinitionNames()));
        beanFactory.registerSingleton("s102", Student.create());
    }
}
