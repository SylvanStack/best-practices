package com.yuanstack.bp.core.design.create.factory.simple;

import com.yuanstack.bp.core.design.create.factory.common.RuleConfig;

/**
 * @description: 配置解析规则
 * @author: hansiyuan
 * @date: 2022/4/1 6:16 PM
 */
public interface RuleConfigParser {
    RuleConfig parse(String configText);
}
