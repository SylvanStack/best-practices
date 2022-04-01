package com.yuanstack.bp.core.design.create.factory.method;

import com.yuanstack.bp.core.design.create.factory.common.InvalidRuleConfigException;
import com.yuanstack.bp.core.design.create.factory.common.RuleConfig;
import com.yuanstack.bp.core.design.create.factory.simple.RuleConfigParser;

/**
 * @description: 规则配置源
 * @author: hansiyuan
 * @date: 2022/4/1 6:40 PM
 */
public class RuleConfigSourceV3 {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        RuleConfigParserFactoryV3 parserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new JsonRuleConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new XmlRuleConfigParserFactory();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new YamlRuleConfigParserFactory();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new PropertiesRuleConfigParserFactory();
        } else {
            try {
                throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
            } catch (InvalidRuleConfigException e) {
                e.printStackTrace();
            }
        }
        RuleConfigParser parser = parserFactory.createParser();
        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }
    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return"json";
    }
}
