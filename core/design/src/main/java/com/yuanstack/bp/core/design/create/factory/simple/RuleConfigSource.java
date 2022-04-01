package com.yuanstack.bp.core.design.create.factory.simple;

import com.yuanstack.bp.core.design.create.factory.common.RuleConfig;

/**
 * @description: 规则配置源
 * @author: hansiyuan
 * @date: 2022/4/1 6:22 PM
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        RuleConfigParser parser = RuleConfigParserFactory.getRuleConfigParser(ruleConfigFilePath, ruleConfigFileExtension);
        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
