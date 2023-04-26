package com.fangs.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * @author fangs
 */
public class LevelOrder {
    public static void main(String[] args) {
        // 创建二叉树 [3,9,20,null,null,15,7]
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        LevelOrder levelOrder = new LevelOrder();
        // 调用层序遍历方法
        List<List<Integer>> result = levelOrder.levelOrder(root);

        // 输出结果
        System.out.println(result);
    }

    private List<List<Integer>> res = new ArrayList<>();

    int depth = 0;

    /**
     * 递归遍历
     *
     * @param root 二叉树节点
     * @return 遍历结果
     * @author fangs
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> curr;
        if (res.size() > depth) {
            curr = res.get(depth);
        } else {
            curr = new ArrayList<>();
            res.add(curr);
        }
        curr.add(root.val);
        int currDepth = depth;
        depth++;
        levelOrder(root.left);
        depth = currDepth + 1;
        levelOrder(root.right);
        return res;
    }

    /**
     * 使用队列缓存层级所有节点
     *
     * @param root 二叉树节点
     * @return 遍历结果
     * @author fangs
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

}
