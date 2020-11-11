package com.datastructure.linkedlist;

/**
 *  * 实例FindFirstIntersectNode
 *  * 给定两个可能有环也可能无环的单链表，头节点head1 和 head2。
 *    请事先一个函数，如果两个链表相交，请返回相交的第一个节点。如果不相交，返回null
 *    要求：如果两个链表长度之和为N，时间复杂度达到O(N)，额外空间复杂度O(1)
 *  * @version 1.0
 *  情况一：两个无环链表的第一个相交节点
 *      head1的长度 length1、head2的长度length2。长度差为n
 *      长度长的指针先向前移动n步
 *      两个链表在同步遍历，第一个相等的节点为交点
 *  情况二：head1有环、head2无环
 *      不可能相交
 *  情况三：均有环（head1 环交点 loop1  head2 环交点 loop2）
 *      入环节点是同一个，则直接判断loop2 == loop1，则情况同情况一
 *      从loop1开始遍历，循环过程中有如下情况
 *          loop1 == loop2，则返回任一节点即可，否则返回null
 *
 *
 *  考点：
 *    1、查找有环单链表的入环位置
 *    2、查找两个无环单链表的交点位置
 *    3、查询两个有环单链表的交点位置
 */
public class FindFirstIntersectNode {
    public static class Node {
        int value;
        Node next;
        Node(int val) { value = val; }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return findNoLoopNode(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return findLoopNode(head1, loop1, head2, loop2);
        }
        return null;
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            if (fast.next == null || slow.next == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node findNoLoopNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int n = 0;
        Node n1 = head1;
        Node n2 = head2;
        while(n1.next != null) {
            n++;
            n1 = n1.next;
        }
        while(n2.next != null) {
            n--;
            n2 = n2.next;
        }
        // 如果有交点的话，最后尾节点一定相等
        if (n1 != n2) {
            return null;
        }
        // n  :  链表1长度减去链表2长度的值
        n1 = n > 0 ? head1 : head2;  //n1 谁长，谁的头变成cur1
        n2 = n1 == head1 ? head2 : head1;  //谁短，谁的头变成cur2
        n = Math.abs(n);
        while (n != 0) {
            n--;
            n1 = n1.next;
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node findLoopNode(Node head1, Node loop1, Node head2, Node loop2) {
        if (loop1 == loop2) {
            int n = 0;
            Node n1 = head1;
            Node n2 = head2;
            while(n1.next != loop1) {
                n++;
                n1 = n1.next;
            }
            while(n2.next != loop2) {
                n--;
                n2 = n2.next;
            }
            // 如果有交点的话，最后尾节点一定相等
            if (n1 != n2) {
                return null;
            }
            // n  :  链表1长度减去链表2长度的值
            n1 = n > 0 ? head1 : head2;  //n1 谁长，谁的头变成cur1
            n2 = n1 == head1 ? head2 : head1;  //谁短，谁的头变成cur2
            n = Math.abs(n);
            while (n != 0) {
                n--;
                n1 = n1.next;
            }
            while (n1 != n2) {
                n1 = n1.next;
                n2 = n2.next;
            }
            return n1;

        } else {
            Node start = loop1;
            while (loop1 != loop2) {
                loop1 = loop1.next;
                if (loop1 == start) {
                    return null;
                }
            }
            return loop1;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
