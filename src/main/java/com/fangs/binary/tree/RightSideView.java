package com.fangs.binary.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @author fangs
 */
public class RightSideView {

    /**
     * 广度优先算法
     * 解题思路：层序遍历树，记录每层最右侧的节点
     *
     * @param root
     * @return
     * @author fangs
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size() > 0) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = stack.pop();
                if (i == 0) {
                    res.add(t.val);
                }
                if (t.right != null) {
                    stack.add(t.right);
                }
                if (t.left != null) {
                    stack.add(t.left);
                }
            }
        }
        return res;
    }

    List<Integer> res2 = new ArrayList<>();

    /**
     * 深度优先算法
     * 使用后序遍历，记录每层第一个元素
     *
     * @param root
     * @return
     * @author fangs
     */
    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) {
            return res2;
        }
        rightSideView2(root, 0);
        return res2;
    }


    public List<Integer> rightSideView2(TreeNode root, int depth) {
        if (root == null) {
            return res2;
        }
        if (res2.size() <= depth) {
            res2.add(root.val);
        }
        depth++;
        rightSideView2(root.right, depth);
        rightSideView2(root.left, depth);
        return res2;
    }
}
