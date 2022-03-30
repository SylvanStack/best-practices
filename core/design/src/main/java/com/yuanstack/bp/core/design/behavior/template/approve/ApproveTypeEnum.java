package com.yuanstack.bp.core.design.behavior.template.approve;

import lombok.Getter;

/**
 * 审批类型枚举
 *
 * @author hansiyuan
 */
public enum ApproveTypeEnum {

    HOME(10000, "首页", new HomeApproveCallback());

    private Integer code;
    private String desc;
    @Getter
    private ApproveCallback callback;

    ApproveTypeEnum(Integer code, String desc, ApproveCallback callback) {
        this.callback = callback;
        this.desc = desc;
        this.code = code;
    }
}
