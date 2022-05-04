package com.yuanstack.bp.core.algo.leetcode.top100.easy;

import com.yuanstack.bp.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年05月04日 12:43
 */
public class T94 {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
