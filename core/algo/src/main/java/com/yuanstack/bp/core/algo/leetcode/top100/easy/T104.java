package com.yuanstack.bp.core.algo.leetcode.top100.easy;

import com.yuanstack.bp.core.TreeNode;

/**
 * @author hansiyuan
 * @date 2022年05月04日 12:46
 */
public class T104 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}


