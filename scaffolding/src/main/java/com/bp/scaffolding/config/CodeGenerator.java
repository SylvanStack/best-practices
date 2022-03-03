package com.bp.scaffolding.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @description: 代码生成
 * @author: hansiyuan
 * @date: 2022/3/2 6:59 PM
 */
public class CodeGenerator {
    public static void main(String[] args) {
        //1、全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //开启AR模式
        config.setActiveRecord(true)
                //设置作者
                .setAuthor("hansiyuan")
                //生成路径(一般在此项目的src/main/java下)
                .setOutputDir(projectPath + "/src/main/java")
                //第二次生成会把第一次生成的覆盖掉
                .setFileOverride(true)
                //生成完毕后是否自动打开输出目录
                .setOpen(true)
                //.setSwagger2(true)//实体属性 Swagger2 注解
                //.setIdType(IdType.AUTO)//主键策略
                //生成的service接口名字首字母是否为I，这样设置就没有I
                .setServiceName("%sService")
                //生成resultMap
                .setBaseResultMap(true)
                //在xml中生成基础列
                .setBaseColumnList(true);
        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false")
                .setUsername("root")
                .setPassword("mysql123456");
        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //开启全局大写命名
        strategyConfig.setCapitalMode(true)
                //表名映射到实体的命名策略(下划线到驼峰)
                .setNaming(NamingStrategy.underline_to_camel)
                //表字段映射属性名策略(未指定按naming)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //.setTablePrefix("tb_")//表名前缀
                //.setSuperEntityClass("你自己的父类实体,没有就不用设置!")
                //.setSuperEntityColumns("id");//写于父类中的公共字段
                //.setSuperControllerClass("自定义继承的Controller类全称，带包名,没有就不用设置!")
                //生成 @RestController 控制器
                .setRestControllerStyle(true)
                //使用lombok
                .setEntityLombokModel(true)
                //逆向工程使用的表
                .setInclude("user");
        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        //设置包名的parent
        packageConfig.setParent("com.bp.scaffolding")
                .setMapper("mapper")
                .setService("service")
                .setController("api")
                .setEntity("domain.model")
                //设置xml文件的目录
                .setXml("mapper");
        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        //6、执行
        autoGenerator.execute();
    }
}
