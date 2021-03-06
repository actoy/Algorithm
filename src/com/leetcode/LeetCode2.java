package com.leetcode;

/**
 *  * 实例LeetCode2
 *  * 两数相加
 *  * @version 1.0
 *  
 */

public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode result = head;
        int tmpNum = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + tmpNum;
            l1 = l1.next;
            l2 = l2.next;
            head.next = new ListNode(sum % 10);
            tmpNum = sum / 10;
            head = head.next;
        }
        while (l1 != null) {
            int sum = l1.val + tmpNum;
            head.next = new ListNode(sum % 10);
            tmpNum = sum / 10;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + tmpNum;
            head.next = new ListNode(sum % 10);
            tmpNum = sum / 10;
            head = head.next;
            l2 = l2.next;
        }
        if (tmpNum > 0) {
            head.next = new ListNode(tmpNum);
        }

        return result.next;
    }
}
