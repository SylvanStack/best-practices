package com.yuanstack.bp.core.algo.linked;

import com.yuanstack.bp.core.structure.linked.LinkedListAlgo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListAlgoTest {

    private LinkedListAlgo.Node list;

    @BeforeEach
    void setUp() {
        list = new LinkedListAlgo.Node(1,
                new LinkedListAlgo.Node(2,
                        new LinkedListAlgo.Node(3,
                                new LinkedListAlgo.Node(4,
                                        new LinkedListAlgo.Node(5, null)))));
    }

    /**
    /**
     * 链表反转
     */
    @Test
    void reverse() {
        LinkedListAlgo.Node reverseLinkedList = LinkedListAlgo.reverse(list);
        LinkedListAlgo.printAll(reverseLinkedList);
    }

    /**
     * 检查环
     */
    @Test
    void checkCircle() {
        System.out.println(LinkedListAlgo.checkCircle(list));
    }

    @Test
    void mergeTwoLists() {
    }

    @Test
    void deleteLastKth() {
    }

    @Test
    void findMiddleNode() {
    }

    @Test
    void printAll() {
    }

    @Test
    void createNode() {
    }
}