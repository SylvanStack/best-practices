package com.yuanstack.bp.core.design.create.factory.abstractfactory;

import com.yuanstack.bp.core.design.create.factory.simple.RuleConfigParser;

/**
 * @description: 抽象工厂
 * @author: hansiyuan
 * @date: 2022/4/1 6:50 PM
 */
public interface AbstractConfigParserFactory {

    RuleConfigParser createRuleParser();

    SystemConfigParser createSystemParser();

    //此处可以扩展新的parser类型，比如IBizConfigParser
}
