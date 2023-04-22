package com.fangs.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * @author fangs
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        //测试下方的前序遍历递归算法
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = left;
        PreorderTraversal solution = new PreorderTraversal();
        System.out.println("答案");
        //递归法测试
        System.out.println(solution.preorderTraversal(root));

        //迭代法测试
        System.out.println(solution.preorderTraversal2(root));
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    LinkedList<TreeNode> stack = new LinkedList<>();

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return res;
        }
        boolean hasNext = true;
        while (hasNext) {
            hasNext = false;
            res.add(root.val);
            if (root.left != null) {
                stack.push(root);
                root = root.left;
                hasNext = true;
            } else if (root.right != null) {
                root = root.right;
                hasNext = true;
            } else {
                while (stack.size() > 0) {
                    root = stack.pop();
                    if (root.right != null) {
                        root = root.right;
                        hasNext = true;
                        break;
                    }
                }
            }

        }
        return res;
    }
}
