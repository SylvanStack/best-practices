package com.yuanstack.bp.core.structure.linked;

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

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
