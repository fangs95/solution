package com.fangs.binary.tree;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author fangs
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        // 创建示例中的二叉树
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;

        ZigzagLevelOrder solution = new ZigzagLevelOrder();

        // 测试zigzagLevelOrder方法
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // 打印结果
        for (List<Integer> level : result) {
            System.out.print("[");
            for (int i = 0; i < level.size(); i++) {
                System.out.print(level.get(i));
                if (i != level.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    LinkedList<TreeNode> stack = new LinkedList<>();

    /**
     * 解法思路：使用一个双段队列，一头存，一头取。没下一层就存取互换一头
     *
     * @param root
     * @return
     * @author fangs
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        stack.push(root);
        while (stack.size() > 0) {
            int size = stack.size();
            List<Integer> list = new ArrayList<>();
            int level = res.size();
            boolean isRightStart = false;
            if ((level & 1) == 1) {
                isRightStart = true;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node;
                if (isRightStart) {
                    node = stack.poll();
                } else {
                    node = stack.pollLast();
                }
                list.add(node.val);
                if (isRightStart) {
                    if (node.right != null) {
                        stack.add(node.right);
                    }
                    if (node.left != null) {
                        stack.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * leetcode官方解法，
     * 区别：增加一个队列用来临时记录一层的元素，当上一层处理完后，批量加入到全局对列中
     *
     * @param root
     * @return
     * @author fangs
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}
