package com.yuanstack.bp.core.design.behavior.template.approve;

/**
 * @description: 审批回调
 * @author: hansiyuan
 * @date: 2022/3/30 3:01 PM
 */
public interface ApproveCallback {

    /**
     * 审批成功回调
     *
     * @param approve 审批信息
     * @return True 审批成功 False 审批失败
     */
    boolean approveSuccess(Approve approve);
}
