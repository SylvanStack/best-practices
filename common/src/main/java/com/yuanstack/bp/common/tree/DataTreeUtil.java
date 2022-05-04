package com.yuanstack.bp.common.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月27日 23:40
 */
public class DataTreeUtil {

    //构造无根树形结构数据，比如系统左侧菜单栏
    public static <ID,T extends DataTree<T,ID>> List<T>
    buildTreeWithoutRoot(List<T> paramList, ID rootNodeId) {
        List<T> returnList = new ArrayList<T>();
        for (T node : paramList) {//查找根节点
            //从2级节点开始构造
            if (node.getParentId().equals(rootNodeId)) {
                returnList.add(node);
            }
        }
        for (T entry : paramList) {
            toTreeChildren(returnList, entry);
        }
        return returnList;
    }

    //构造只有一个根的树形结构数据
    public static <ID,T extends DataTree<T,ID>> List<T>
    buildTree(List<T> paramList, ID rootNodeId) {
        List<T> returnList = new ArrayList<T>();
        for (T node : paramList) {//查找根节点
            //从1级节点开始构造
            if (node.getId().equals(rootNodeId)) {
                returnList.add(node);
            }
        }
        for (T entry : paramList) {
            toTreeChildren(returnList, entry);
        }
        return returnList;
    }

    private static <ID,T extends DataTree<T,ID>>
    void toTreeChildren(List<T> returnList, T entry) {
        for (T node : returnList) {
            if (entry.getParentId().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(new ArrayList<T>());
                }
                node.getChildren().add(entry);
            }
            if (node.getChildren() != null) {
                toTreeChildren(node.getChildren(), entry);
            }
        }
    }
}
