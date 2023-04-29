package com.fangs.binary.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BuildTree buildTree = new BuildTree();
        long s = System.currentTimeMillis();
        TreeNode treeNode = buildTree.buildTree(preorder, inorder);
        System.out.println("完成时间：" + (System.currentTimeMillis() - s));
        System.out.println(treeNode);

    }

    private Map<Integer, Integer> inorderMap;

    /**
     * 递归法
     *
     * @param preorder
     * @param inorder
     * @return
     * @author fangs
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        inorderMap = new HashMap<>((int) (inorder.length / 0.75D + 1));
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int pIndex, int pIndexEnd, int iStart, int iEnd) {
        if (pIndex >= pIndexEnd) {
            return null;
        }
        //left
        int left = preorder[pIndex];
        int inorderIndex = inorderMap.get(left);
        int leftSize = inorderIndex - iStart;
        TreeNode r = new TreeNode(left);
        TreeNode leftNode = buildTree(preorder, pIndex + 1, pIndex + leftSize + 1, iStart, inorderIndex);
        TreeNode rightNode = buildTree(preorder, pIndex + leftSize + 1, pIndexEnd, inorderIndex + 1, iEnd);
        r.left = leftNode;
        r.right = rightNode;
        return r;
    }
}
