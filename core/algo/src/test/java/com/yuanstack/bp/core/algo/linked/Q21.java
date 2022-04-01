package com.yuanstack.bp.core.algo.linked;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @description: 21. 合并两个有序链表
 * @author: hansiyuan
 * @date: 2022/4/1 3:36 PM
 */
public class Q21 {

    private ListNode sortList1;
    private ListNode sortList2;

    @BeforeEach
    void setUp() {
        sortList1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        sortList2 = new ListNode(1, new ListNode(2, new ListNode(5)));
    }

    @Test
    public void v1() {
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoLists(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }
}
