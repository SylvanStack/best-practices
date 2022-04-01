package com.yuanstack.bp.core.design.create.factory.abstractfactory;

import com.yuanstack.bp.core.design.create.factory.simple.JsonRuleConfigParser;
import com.yuanstack.bp.core.design.create.factory.simple.RuleConfigParser;

/**
 * @description: Json
 * @author: hansiyuan
 * @date: 2022/4/1 6:52 PM
 */
public class AbstractJsonConfigParserFactory implements AbstractConfigParserFactory {
    @Override
    public RuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public SystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}
