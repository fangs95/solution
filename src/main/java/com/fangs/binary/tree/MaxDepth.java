package com.fangs.binary.tree;

import java.util.List;

/**
 * 104. 二叉树的最大深度
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author fangs
 */
public class MaxDepth {
    public static void main(String[] args) {
        //测试下方最大深度算法
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = left;
        MaxDepth solution = new MaxDepth();
        System.out.println("答案");
        System.out.println(solution.maxDepth(root));
    }

    int curr = 0;
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        curr++;
        if (curr > maxDepth) {
            maxDepth = curr;
        }
        int a = curr;
        maxDepth(root.left);
        curr = a;
        maxDepth(root.right);
        return maxDepth;
    }
}
