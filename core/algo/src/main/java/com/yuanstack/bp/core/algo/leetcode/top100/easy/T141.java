package com.yuanstack.bp.core.algo.leetcode.top100.easy;

import com.yuanstack.bp.core.ListNode;

/**
 * @author hansiyuan
 * @date 2022年05月04日 15:15
 */
public class T141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(4))));
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
