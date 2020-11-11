package com.datastructure.linkedlist;

/**
 *  * 实例IsPalindromeList
 *  * 给一个链表，判断该链表是否为回文结构
 *  * @version 1.0
 *  * 方法一：从head遍历，将value存放在栈中，然后把栈中元素依次弹出，和链表从head遍历依次比较
 *  * 方法二：从中点的位置往后的节点，依次存储在stack中，然后栈中元素依次弹出，和链表从head遍历依次比较
 *  * 方法三：从中点的位置往后的节点，指针翻转，从left和right两个指针依次遍历比较（改链表结构）
 */
public class IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node n1 = head;
        Node n2 = head;
        while(n2.next != null && n2.next.next != null) {
            //n1 -> mid
            n1 = n1.next;
            //n2 -> end
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        //n3 -> save last node
        n3 = n1;
        n2 = head;
        boolean res = true;
        //大小比较
        while(n2 != null && n1 != null) {
            if (n2.value != n1.value) {
                res = false;
                break;
            }
            n2 = n2.next;
            n1 = n1.next;
        }
        //recover list
        n1 = n3.next;
        n3.next = null;
        while(n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
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

        Node head = null;
        printLinkedList(head);
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

}
