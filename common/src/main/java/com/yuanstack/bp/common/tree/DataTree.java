package com.yuanstack.bp.common.tree;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月27日 23:39
 */
public interface DataTree<T,ID> {
    //维护树形关系：元素一
    public ID getId();
    //维护树形关系：元素二
    public ID getParentId();
    //子节点数组
    public void setChildren(List<T> children);

    public List<T> getChildren();
}

