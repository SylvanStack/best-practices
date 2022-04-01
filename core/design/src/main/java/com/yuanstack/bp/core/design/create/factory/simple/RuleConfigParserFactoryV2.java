package com.yuanstack.bp.core.design.create.factory.simple;

import com.yuanstack.bp.core.design.create.factory.simple.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 工厂添加缓存
 * @author: hansiyuan
 * @date: 2022/4/1 6:27 PM
 */
public class RuleConfigParserFactoryV2 {
    private static final Map<String, RuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static RuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            //返回null还是IllegalArgumentException全凭你自己说了算
            return null;
        }
        RuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}
