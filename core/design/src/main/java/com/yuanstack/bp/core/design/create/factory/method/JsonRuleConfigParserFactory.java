package com.yuanstack.bp.core.design.create.factory.method;

import com.yuanstack.bp.core.design.create.factory.method.RuleConfigParserFactoryV3;
import com.yuanstack.bp.core.design.create.factory.simple.JsonRuleConfigParser;
import com.yuanstack.bp.core.design.create.factory.simple.RuleConfigParser;

/**
 * @description: Json源解析工厂
 * @author: hansiyuan
 * @date: 2022/4/1 6:32 PM
 */
public class JsonRuleConfigParserFactory implements RuleConfigParserFactoryV3 {
    @Override
    public RuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
