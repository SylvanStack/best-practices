package com.yuanstack.bp.core.algo.leetcode.top100.easy;

import com.yuanstack.bp.core.ListNode;

/**
 * @author hansiyuan
 * @date 2022年05月04日 12:11
 */
public class T21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
