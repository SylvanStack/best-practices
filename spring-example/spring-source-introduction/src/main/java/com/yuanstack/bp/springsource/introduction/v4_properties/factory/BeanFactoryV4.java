package com.yuanstack.bp.springsource.introduction.v4_properties.factory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author hansiyuan
 * @date 2022年03月29日 23:06
 */
public class BeanFactoryV4 {

    private static Properties properties;

    // 使用静态代码块初始化properties，加载factory_d.properties文件
    static {
        properties = new Properties();
        try {
            properties.load(BeanFactoryV4.class.getClassLoader().getResourceAsStream("v4.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }
    }

    public static Object getBean(String beanName) {
        try {
            // 从properties文件中读取指定name对应类的全限定名，并反射实例化
            Class<?> beanClazz = Class.forName(properties.getProperty(beanName));
            return beanClazz.newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("[" + beanName + "] instantiation error!", e);
        }
    }

}
