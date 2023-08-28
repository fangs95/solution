package com.fangs.linked;

import com.fangs.common.ListNode;

import java.util.LinkedList;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * @author fangs
 */
public class ReverseBetween {

    //写一个测试反转链表的main方法
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        int[] nums = {2};
        for (int num : nums) {
            ListNode node = new ListNode(num);
            curr.next = node;
            curr = node;
        }
        ReverseBetween r = new ReverseBetween();
        ListNode res = r.reverseBetween(head, 1, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode curr = head;
        int i = 0;
        ListNode tHead = null, th = null, tEnd = null, end = null;
        while (curr != null && i <= right) {
            if (i == (left - 2)) {
                tHead = curr;
            }
            if (i == (left - 1)) {
                th = curr;
            }
            if (i == right) {
                end = curr;
            }
            if (i == (right - 1)) {
                tEnd = curr;
            }
            i++;
            curr = curr.next;
        }
        ListNode reverse = reverse(tHead, th, tEnd, end);
        return reverse == null ? head : reverse;
    }

    public ListNode reverse(ListNode head, ListNode thead, ListNode tEnd, ListNode end) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode curr = thead;
        stack.push(curr);
        while (curr != null && curr.next != end) {
            stack.push(curr.next);
            curr = curr.next;
        }
        curr = head;
        while (!stack.isEmpty()) {
            if (curr != null) {
                curr.next = stack.pop();
                curr = curr.next;
            } else {
                curr = stack.pop();
            }
            if (stack.isEmpty()) {
                curr.next = end;
            }
        }
        if (head == null) {
            return tEnd;
        } else {
            return null;
        }
    }

}
