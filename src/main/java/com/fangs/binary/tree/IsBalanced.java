package com.fangs.binary.tree;

public class IsBalanced {
    public static void main(String[] args) {
//        System.out.println(Math.abs(-5));
        //测试下面的是否平衡算法
        //[1,2,2,3,3,null,null,4,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(4);
        IsBalanced isBalanced = new IsBalanced();
        boolean balanced = isBalanced.isBalanced(root);
        System.out.println("答案：" + balanced);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int i = maxDepth(root);
        return i >= 0;
    }

    /**
     * 计算高度，如果发现不平衡直接返回-1
     *
     * @param root
     * @return
     * @author fangs
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        if (left < 0) {
            return -1;
        }
        int right = maxDepth(root.right);
        if (right < 0 || Math.abs(left - right) > 1) {
            return -1;
        }
        return (left > right ? left : right) + 1;
    }
}
