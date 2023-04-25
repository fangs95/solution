package com.fangs.binary.tree;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 *
 * @author fangs
 */
public class IsSymmetric {

    public static void main(String[] args) {
        // Create a symmetric binary tree
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        TreeNode leftleft1 = new TreeNode(3);
        TreeNode leftright1 = new TreeNode(4);
        TreeNode rightleft1 = new TreeNode(4);
        TreeNode rightright1 = new TreeNode(3);
        root1.left = left1;
        root1.right = right1;
        left1.left = leftleft1;
        left1.right = leftright1;
        right1.left = rightleft1;
        right1.right = rightright1;

        IsSymmetric sbt = new IsSymmetric();
        System.out.println(sbt.isSymmetric2(root1));

        // Create a non-symmetric binary tree
        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(2);
        TreeNode leftright2 = new TreeNode(3);
        TreeNode rightleft2 = new TreeNode(3);
        root2.left = left2;
        root2.right = right2;
        left2.right = leftright2;
        right2.left = rightleft2;
        sbt = new IsSymmetric();
        System.out.println(sbt.isSymmetric2(root2));
    }

    LinkedList<TreeNode> leftStack = new LinkedList<>();
    LinkedList<TreeNode> rightStack = new LinkedList<>();

    /**
     * 迭代法
     *
     * @param root
     * @return
     * @author fangs
     */
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (true) {
            if (left == null && right == null) {
                if (leftStack.size() != rightStack.size()) {
                    return false;
                } else if (leftStack.size() > 0 && rightStack.size() > 0) {
                    left = leftStack.pop().right;
                    right = rightStack.pop().left;
                } else {
                    return true;
                }
            } else if (left == null && right != null) {
                return false;
            } else if (left != null && right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            } else {
                leftStack.push(left);
                rightStack.push(right);
                left = left.left;
                right = right.right;
            }
        }
    }

    /**
     * 递归法
     *
     * @param root
     * @return
     * @author fangs
     */
    public boolean isSymmetric2(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric(left, right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        if (isSymmetric(left.left, right.right)) {
            return isSymmetric(left.right, right.left);
        } else {
            return false;
        }
    }

}
