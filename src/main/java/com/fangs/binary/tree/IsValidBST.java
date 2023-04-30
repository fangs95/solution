package com.fangs.binary.tree;

/**
 * 98. 验证二叉搜索树
 *
 * @author fangs
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(Integer.MIN_VALUE, new TreeNode(Integer.MIN_VALUE), null);


        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(root));

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    /**
     * 递归，每次递归计算出子级的取值范围
     *
     * @param root 当前节点
     * @param min  当前节点最小值
     * @param max  当前节点最大值
     * @return 是否是二叉搜索树
     * @author fangs
     */
    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val == Integer.MIN_VALUE && root.left != null) {
            return false;
        }
        if (root.val == Integer.MAX_VALUE && root.right != null) {
            return false;
        }
        if (!isValidBST(root.left, min, root.val - 1)) {
            return false;
        }
        if (!isValidBST(root.right, root.val + 1, max)) {
            return false;
        }
        root.left = null;
        root.right = null;
        return min <= root.val && max >= root.val;
    }
}
