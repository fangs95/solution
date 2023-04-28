package com.fangs.binary.tree;

import java.util.*;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * @author fangs
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode treeNode = lowestCommonAncestor.lowestCommonAncestor(root, node5, node6);
        System.out.println(treeNode);
    }

    Deque<TreeNode> pStack = new LinkedList<>();

    Deque<TreeNode> qStack = new LinkedList<>();

    /**
     * 思路：存储到达目标节点的父节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     * @author fangs
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root, b = root;
        retrieve(a, p, pStack);
        retrieve(b, q, qStack);
        TreeNode ancestor = null;
        while (pStack.size() > 0 && qStack.size() > 0) {
            TreeNode ps = pStack.pollLast();
            TreeNode qs = qStack.pollLast();
            if (ps == qs) {
                ancestor = ps;
            } else {
                break;
            }
        }
        return ancestor;
    }

    private void retrieve(TreeNode root, TreeNode target, Deque<TreeNode> stack) {
        Set<TreeNode> l = new HashSet<>();
        Set<TreeNode> r = new HashSet<>();
        while (root != null || stack.size() > 0) {
            if (root == target) {
                stack.push(root);
                return;
            }
            if (root.left != null && !l.contains(root)) {
                stack.push(root);
                l.add(root);
                root = root.left;
            } else if (root.right != null && !r.contains(root)) {
                stack.push(root);
                r.add(root);
                root = root.right;
            } else {
                root = stack.pop();
            }
        }
    }


    /*
    更好思路，先对该题进行分析发现，满足条件要么是左右子树各一个目标元素，要么是有一个元素是自己，另一个是子级节点
     */
    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    /**
     * leetCode官方解法
     *
     * @param root
     * @param p
     * @param q
     * @return
     * @author fangs
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}
