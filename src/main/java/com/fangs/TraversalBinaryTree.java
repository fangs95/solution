package com.fangs;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * @author fangs
 */
public class TraversalBinaryTree {
    public static void main(String[] args) {
        //测试下面的代码
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = left;
        TraversalBinaryTree solution = new TraversalBinaryTree();
        System.out.println("答案");
        //递归法测试
//        System.out.println(solution.inorderTraversal(root));
        //迭代法
        System.out.println(solution.inorderTraversal2(root));


    }


    //迭代法
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (true){
            if(root.left!=null){
                stack.push(root);
                root = root.left;
                continue;
            }
            list.add(root.val);
            if(root.right!=null){
                root = root.right;
                continue;
            }
            try{
                root = stack.pop();
                root.left = null;
            }catch (EmptyStackException e){
                break;
            }
        }
        return list;
    }


    List<Integer> list = new ArrayList<>();

    //递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) {
            return list;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left!=null) {
            inorderTraversal(left);
        }
        list.add(root.val);
        if (right!=null) {
            inorderTraversal(right);
        }
        return list;
    }
}


/**
 *
 * @author fangs
 */
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


