package com.yuanstack.bp.core.design.behavior.template.approve;


import java.util.Objects;

import static com.yuanstack.bp.core.design.behavior.template.approve.ApproveTypeEnum.HOME;

/**
 * @description: 审批模版
 * @author: hansiyuan
 * @date: 2022/3/30 2:18 PM
 */
public class ApproveTemplateExample {

    /**
     * 保存草稿信息
     *
     * @param draft 草稿信息
     * @return True 保存成功 False 保存失败
     */
    public Boolean saveDraft(Draft draft) {
        if (Objects.isNull(draft)) {
            return false;
        }
        System.out.println("保存或提交草稿信息...");
        return true;
    }

    /**
     * 提交审批信息
     *
     * @param approve 审批信息
     * @return True 保存成功 False 保存失败
     */
    public Boolean saveApprove(Approve approve) {
        if (Objects.isNull(approve)) {
            return false;
        }
        System.out.println("审批...");
        return true;
    }

    /**
     * 快速提交审批（保存草稿数据并直接神品）
     *
     * @param draft 草稿信息
     * @return True 保存成功 False 保存失败
     */
    public Boolean quickSaveApprove(Draft draft) {
        if (Objects.isNull(draft)) {
            return false;
        }
        return saveApprove(new Approve());
    }

    /**
     * 审批操作
     *
     * @param draft 待审批信息
     * @return 审批结果 True 保存成功 False 保存失败
     */
    public Boolean approve(Draft draft) {
        if (Objects.isNull(draft)) {
            return false;
        }
        ApproveCallback callback = HOME.getCallback();
        return callback.approveSuccess(new Approve());
    }

    public static void main(String[] args) {
        ApproveTemplateExample example = new ApproveTemplateExample();
        example.approve(new Draft());
    }
}
