package com.datastructure.linkedlist;

/**
 *  * 实例CopyListWithRandom
 *  * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，
 *    也可能指向null。给定一个由Node节点类型组成的无环单链表的头节点head。
 *    请事先一个函数完成这个链表的复制，并返回复制的新链表的头节点
 *  * @version 1.0
 *  方法一：通过HashMap<Node, Node>来存储。
 *      key => curNode  value => newNode，
 *      即map中存储了当前节点及复制节点的对应关系。
 *      按照原有的head遍历，如map.get(curNode).next = map.get(curNode.next
 *
 *  方法二：当前节点的next指针指向，当前节点的复制节点。
 *      然后通过前后两个指针类似方法一的方式处理
 */
public class CopyListWithRandom {
    public static class Node {
        int value;
        Node next;
        Node rand;
        Node(int val) { value = val; }
    }

    public static Node copyList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // copy node and link to every node
        // 1 -> 2
        // 1 -> 1' -> 2
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // set copy node rand
        // 1 -> 1' -> 2 -> 2'
        while (cur != null) {
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = cur.next.next;
        }
        Node res = head.next;
        cur = head;
        //split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = curCopy.next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res2 = copyList(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        System.out.println("原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");
        res2 = copyList(head);
        System.out.println("方法二的拷贝链表：");
        printRandLinkedList(res2);
        System.out.println("=========================");
        System.out.println("经历方法二拷贝之后的原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
