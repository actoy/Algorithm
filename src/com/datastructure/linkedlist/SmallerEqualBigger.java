package com.datastructure.linkedlist;

/**
 *  * 实例SmallerEqualBigger
 *  * 将单链表按某值划分成左边小、中间相等、右边大的结构
 *  * @version 1.0
 *  方法一：将链表数据存储在数组中，使用partition的方式排序后，在重新组件链表结构
 *  方法二：创建6个指针（记录小于标记值的头、尾指针 / 等于标记值的头、尾指针 / 大于标记值的头、尾指针），
 *         然后遍历list，创建三个范围内的链表，然后小于 尾指针 -> 等于头 等于尾->大于头。
 *         边界条件需要重点考虑，返回串起来链表的最左的头结点
 */
public class SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;
        public Node(int v) {
            value = v;
        }
    }

    public static Node getNewHead(Node head, int flag) {
        if (head == null || head.next == null) {
            return head;
        }
        Node sH = null;
        Node sE = null;
        Node eH = null;
        Node eE = null;
        Node bH = null;
        Node bE = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < flag) {
                if (sE == null) {
                    sH = head;
                    sE = head;
                } else {
                    sE.next = head;
                    sE = head;
                }
            } else if (head.value == flag) {
                if (eE == null) {
                    eH = head;
                    eE = head;
                } else {
                    eE.next = head;
                    eE = head;
                }
            } else {
                if (bE == null) {
                    bH = head;
                    bE = head;
                } else {
                    bE.next = head;
                    bE = head;
                }
            }
            head = next;
        }
        //小于区域的尾巴，连等于区域的头，等于区域的尾巴连大于区域的头
        if (sE != null) { //如果有小于区域
            sE.next = eH;
            eE = eE == null ? sE : eE;
        }
        if (eE != null) {
            eE.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = getNewHead(head1, 5);
        printLinkedList(head1);

    }
}
