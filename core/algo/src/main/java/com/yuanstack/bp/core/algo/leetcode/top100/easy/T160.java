package com.yuanstack.bp.core.algo.leetcode.top100.easy;

import com.yuanstack.bp.core.ListNode;

/**
 * @author hansiyuan
 * @date 2022年05月04日 15:53
 */
public class T160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(4))));
        ListNode headB = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(4))));
        System.out.println(getIntersectionNode(headA, headB));
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
