package com.yuanstack.bp.core;

import lombok.Data;

/**
 * @author hansiyuan
 * @date 2022年05月04日 12:11
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
