package com.yuanstack.bp.core.design.create.factory.method;

import com.yuanstack.bp.core.design.create.factory.method.RuleConfigParserFactoryV3;
import com.yuanstack.bp.core.design.create.factory.simple.RuleConfigParser;
import com.yuanstack.bp.core.design.create.factory.simple.YamlRuleConfigParser;

/**
 * @description: yaml源解析工厂
 * @author: hansiyuan
 * @date: 2022/4/1 6:38 PM
 */
public class YamlRuleConfigParserFactory implements RuleConfigParserFactoryV3 {
    @Override
    public RuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
