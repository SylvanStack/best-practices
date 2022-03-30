package com.yuanstack.bp.core.design.behavior.template.approve;

/**
 * @description: 首页审批回调
 * @author: hansiyuan
 * @date: 2022/3/30 3:05 PM
 */
public class HomeApproveCallback implements ApproveCallback {
    @Override
    public boolean approveSuccess(Approve approve) {
        System.out.println("首页审批回调...");
        return true;
    }
}
