package com.yuanstack.bp.core.design.create.factory.method;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 工厂的工厂
 * @author: hansiyuan
 * @date: 2022/4/1 6:47 PM
 */
public class RuleConfigParserFactoryMap {
    private static final Map<String, RuleConfigParserFactoryV3> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static RuleConfigParserFactoryV3 getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        RuleConfigParserFactoryV3 parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }
}
