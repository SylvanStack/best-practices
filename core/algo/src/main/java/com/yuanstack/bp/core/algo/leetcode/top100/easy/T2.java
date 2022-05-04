package com.yuanstack.bp.core.algo.leetcode.top100.easy;

import com.yuanstack.bp.core.ListNode;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年05月03日 21:36
 */
public class T2 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        //ListNode listNode = addTwoNumbers(l1, l2);
        //printfAll(listNode);
        int v1Val = listNodeConvertVal(l1);
        int v2Val = listNodeConvertVal(l2);
        int v3val = v1Val + v2Val;
        ListNode result = valConvertListNode(v3val);
        printfAll(result);
    }

    private static ListNode valConvertListNode(int v3val) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (v3val > 0) {
            int currVal = v3val % 10;
            curr.next = new ListNode(currVal);
            v3val = v3val / 10;
            curr = curr.next;
        }
        return result.next;
    }

    private static int listNodeConvertVal(ListNode listNode) {
        int val = 0;
        while (listNode != null) {
            val = val * 10 + listNode.val;
            listNode = listNode.next;
        }
        return val;
    }

    private static void printfAll(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;
    }

}
