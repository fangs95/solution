package com.fangs.sort;

import com.fangs.common.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @author fangs
 */
public class MergeKLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        MergeKLists mergeKLists = new MergeKLists();
        ListNode result = mergeKLists.mergeKLists2(lists);

        while (result != null) {
            System.out.printf(result.val + " ");
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = getMinNode(lists);
        ListNode curr = res;
        for (; ; ) {
            ListNode node = getMinNode(lists);
            if (node == null) {
                break;
            } else {
                curr.next = node;
                curr = node;
            }
        }
        return res;
    }

    public ListNode getMinNode(ListNode[] lists) {
        ListNode curr = null;
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null && (curr == null || curr.val > node.val)) {
                curr = node;
                minIndex = i;
            }
        }
        if (curr != null) {
            lists[minIndex] = lists[minIndex].next;
        }
        return curr;
    }

    /**
     * 小顶堆实现（优先级队列）
     *
     * @param lists
     * @return
     * @author fangs
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 初始化优先队列
        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (!queue.isEmpty()) {
            Status currStatus = queue.poll();
            tail.next = currStatus.ptr;
            tail = tail.next;
            if (currStatus.ptr.next != null) {
                queue.offer(new Status(currStatus.ptr.next.val, currStatus.ptr.next));
            }
        }

        return dummyHead.next;
    }

}

class Status implements Comparable<Status> {
    int val;
    ListNode ptr;

    Status(int val, ListNode ptr) {
        this.val = val;
        this.ptr = ptr;
    }

    public int compareTo(Status status2) {
        return this.val - status2.val;
    }
}
