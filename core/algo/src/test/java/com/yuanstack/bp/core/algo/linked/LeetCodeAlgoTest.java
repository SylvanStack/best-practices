package com.yuanstack.bp.core.algo.linked;

import com.yuanstack.bp.core.structure.linked.LinkedListAlgo;
import com.yuanstack.bp.core.structure.linked.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @description: LeeCode算法练习
 * @author: hansiyuan
 * @date: 2022/4/1 3:21 PM
 */
public class LeetCodeAlgoTest {

    private LinkedListAlgo.Node list;
    private ListNode sortList1;
    private ListNode sortList2;

    @BeforeEach
    void setUp() {
        list = new LinkedListAlgo.Node(1,
                new LinkedListAlgo.Node(2,
                        new LinkedListAlgo.Node(3,
                                new LinkedListAlgo.Node(4,
                                        new LinkedListAlgo.Node(5, null)))));
        sortList1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        sortList2 = new ListNode(1, new ListNode(2, new ListNode(5)));
    }

    @Test
    public void questionIndex2() {

    }

    @Test
    public void questionIndex19() {

    }



    @Test
    public void questionIndex23() {

    }

    @Test
    public void questionIndex114() {

    }

    @Test
    public void questionIndex141() {

    }

    @Test
    public void questionIndex142() {

    }

    @Test
    public void questionIndex146() {

    }

    @Test
    public void questionIndex148() {

    }

    @Test
    public void questionIndex160() {

    }

    @Test
    public void questionIndex206() {

    }

    @Test
    public void questionIndex234() {

    }
}
