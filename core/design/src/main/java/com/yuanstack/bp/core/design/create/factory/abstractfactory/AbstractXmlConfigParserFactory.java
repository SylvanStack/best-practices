package com.yuanstack.bp.core.design.create.factory.abstractfactory;

import com.yuanstack.bp.core.design.create.factory.simple.RuleConfigParser;
import com.yuanstack.bp.core.design.create.factory.simple.XmlRuleConfigParser;

/**
 * @description: 抽象XMl
 * @author: hansiyuan
 * @date: 2022/4/1 6:53 PM
 */
public class AbstractXmlConfigParserFactory  implements AbstractConfigParserFactory {
    @Override
    public RuleConfigParser createRuleParser() {
        return new XmlRuleConfigParser();
    }

    @Override
    public SystemConfigParser createSystemParser() {
        return new XmlSystemConfigParser();
    }
}
