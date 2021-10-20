package com.example.demo.algo.linked;

/**
 * @description: 单链表
 * @author: hansiyuan
 * @date: 2021/10/12 6:27 下午
 */
public class SinglyLinkedList {
    private Node head = null;

    /*
     * 1. 通过value查询结点
     * 2. 通过index查询结点
     * 3. 插入到头部(值、结点)
     * 4. 插入到尾部（值、结点）
     * 5. 在节点前插入（值、结点）
     * 6. 在节点后插入（值、结点）
     * 7. 删除结点（值、结点）
     * 8. 打印结点
     * 9. 判断回文
     * 10. 列表反转
     */

    public void delByNode(Node node) {
        Node tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.next == node) {
                tempNode.next = tempNode.next.next;
            }
        }
    }

    public Node findByIndex(int index) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (count == index) {
                return temp;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }


    /**
     * 判断是否为回文
     *
     * @return true 是 false 否
     */
    public boolean isPalindrome() {
        /*
         * 解题思路：
         *    1. 反转 对比
         */
        Node temp = head;
        Node node = linkedReversal();
        while (temp != null) {
            if (temp.data != node.data) {
                return false;
            }
            temp = temp.next;
            node = node.next;
        }
        return true;
    }


    /**
     * 链表反转
     *
     * @return 头结点
     */
    public Node linkedReversal() {
        Node copyNode = head;
        Node resultNode = null;
        while (copyNode != null) {
            Node tempNode = copyNode;
            copyNode = copyNode.next;
            tempNode.next = resultNode;
            resultNode = tempNode;
        }
        return resultNode;
    }

    public void insetHead(int value) {
        if (head == null) {
            head = new Node(value, null);
        } else {
            Node newNode = new Node(value, null);
            newNode.next = head;
            head = newNode;
        }
    }

    public void insetHead(Node newNode) {
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void printfData() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }
    }

    public void printfData(Node node) {
        Node tempNode = node;
        while (tempNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }
    }

    public void delByValue(int value) {
        // 边界条件
        if (head == null) {
            return;
        }
        Node temp = head;
        Node delNode = null;
        while (temp.next != null) {
            if (temp.next.data == value) {
                delNode = temp;
                break;
            }
            temp = temp.next;
        }

        if (delNode != null) {
            delNode.next = delNode.next.next;
        }

    }

    public void delByIndex(int index) {
        int count = 0;
        while (head != null) {
            if (count == index) {
                head = head.next;
                break;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insetHead(1);
        list.insetHead(2);
        list.insetHead(2);
        list.insetHead(new Node(1, null));
//        Node node = list.linkedReversal();
//        list.printfData(node);
//        System.out.println(list.isPalindrome());
        Node index_1 = list.findByIndex(1);
        System.out.println(index_1.data);
//        list.printfData();
    }


    /**
     * 结点
     */
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }


}
