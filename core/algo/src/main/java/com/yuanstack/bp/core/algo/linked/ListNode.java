package com.yuanstack.bp.core.algo.linked;

/**
 * @description: 链表节点
 * @author: hansiyuan
 * @date: 2022/4/1 3:29 PM
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
