package com.fangs.binary.tree;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * @author fangs
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11, null, null);

        TreeNode node4 = new TreeNode(4, node7, null);
        TreeNode node5 = new TreeNode(5, null, node8);
        TreeNode node6 = new TreeNode(6, node9, node10);

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, node6);

        TreeNode root = new TreeNode(1, node2, node3);

        node8.left = node11;

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int i = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println("最大径向长度：" + i);
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth2(root);
        return max;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        int curr = left + right;
        if (curr > max) {
            max = curr;
        }
        return (left > right ? left : right) + 1;
    }
}
