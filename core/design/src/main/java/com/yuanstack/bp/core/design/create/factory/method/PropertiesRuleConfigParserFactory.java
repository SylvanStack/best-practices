package com.yuanstack.bp.core.design.create.factory.method;

import com.yuanstack.bp.core.design.create.factory.method.RuleConfigParserFactoryV3;
import com.yuanstack.bp.core.design.create.factory.simple.PropertiesRuleConfigParser;
import com.yuanstack.bp.core.design.create.factory.simple.RuleConfigParser;

/**
 * @description: Properties源解析工厂
 * @author: hansiyuan
 * @date: 2022/4/1 6:39 PM
 */
public class PropertiesRuleConfigParserFactory implements RuleConfigParserFactoryV3 {
    @Override
    public RuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
