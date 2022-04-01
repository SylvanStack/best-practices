package com.yuanstack.bp.core.design.create.factory.simple;

import com.yuanstack.bp.core.design.create.factory.common.InvalidRuleConfigException;

/**
 * 简单的工厂实现
 *
 * @author hansiyuan
 * @date 2022年03月15日 0:01
 */
public class RuleConfigParserFactory {

    public static RuleConfigParser getRuleConfigParser(String ruleConfigFilePath, String ruleConfigFileExtension) {
        RuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new PropertiesRuleConfigParser();
        } else {
            try {
                throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
            } catch (InvalidRuleConfigException e) {
                e.printStackTrace();
            }
        }
        return parser;
    }

}
