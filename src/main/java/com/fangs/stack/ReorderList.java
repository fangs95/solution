package com.fangs.stack;

import com.fangs.common.ListNode;

import java.util.LinkedList;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author fangs
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println("Original list:");
        printList(n1);

        ReorderList reorderList = new ReorderList();

        reorderList.reorderList(n1);

        System.out.println("Reordered list:");
        printList(n1);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode curr = head;
        for (; ; ) {
            stack.push(curr);
            if (curr.next == null) {
                break;
            } else {
                curr = curr.next;
            }
        }
        curr = head;
        int len = stack.size();
        for (int i = 0; i <= len / 2; i++) {
            ListNode e = stack.pop();
            if (e == curr) {
                break;
            }
            ListNode next = curr.next;
            curr.next = e;
            e.next = next;
            curr = next;
        }
        curr.next = null;
    }
}
