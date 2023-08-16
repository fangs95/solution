package com.fangs.sliding.window;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import com.fangs.common.ListNode;

import java.util.LinkedList;

/**
 * 25. K 个一组翻转链表
 *
 * @author fangs
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        //生成一个ListNode的链表,并打印
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 4; i++) {
            ListNode next = new ListNode(i);
            curr.next = next;
            curr = next;
        }

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode listNode = reverseKGroup.reverseKGroup(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode startLast = null;
        ListNode start = head;
        for (; ; ) {
            LinkedList<ListNode> stack = getNextK(start, k);
            if (stack == null) {
                break;
            }
            if (startLast == null) {
                head = stack.peek();
            }
            if (reverse(startLast, start, stack, k)) {
                break;
            }
            startLast = start;
            start = start.next;
        }
        return head;
    }

    private LinkedList<ListNode> getNextK(ListNode curr, int k) {
        LinkedList<ListNode> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                return null;
            }
            stack.push(curr);
            curr = curr.next;
        }
        return stack;
    }

    private boolean reverse(ListNode startLast, ListNode start, LinkedList<ListNode> stack, int k) {
        if (stack.size() < k) {
            return true;
        }
        for (int i = 0; i < k / 2; i++) {
            ListNode end = stack.pop();
            ListNode sNext = start.next;
            ListNode eNext = end.next;

            if (sNext == end) {
                end.next = start;
            } else {
                end.next = sNext;
                stack.peek().next = start;
            }
            start.next = eNext;

            if (startLast != null) {
                startLast.next = end;
            }
            start = sNext;
            startLast = end;
        }
        return false;
    }
}
