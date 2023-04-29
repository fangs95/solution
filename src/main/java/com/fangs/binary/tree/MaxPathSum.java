package com.fangs.binary.tree;

/**
 * 124. 二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class MaxPathSum {
    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumForSide(root);
        return sum;
    }

    private int maxPathSumForSide(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSumForSide(root.left);
        int right = maxPathSumForSide(root.right);
        //比较找出最大和路劲的单边
        int c = left > right ? left : right;
        //计算加上root节点值的最大单边，如果子级最大单边是负数，就舍弃掉子级和
        int maxSide;
        if (c > 0) {
            maxSide = c + root.val;
        } else {
            maxSide = root.val;
        }
        //将所有子节点和与本节点最大单边比较，记录最大路径和
        int s = left + right + root.val;
        int ss = s > maxSide ? s : maxSide;
        if (ss > sum) {
            sum = ss;
        }
        //返回本节点的最大单边路劲和
        return maxSide;
    }
}
