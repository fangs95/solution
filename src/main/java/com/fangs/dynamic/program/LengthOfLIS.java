package com.fangs.dynamic.program;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @author fangs
 */
public class LengthOfLIS {
    /**
     * 动态规划算法
     *
     * @param nums
     * @return
     * @author fangs
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] data = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            data[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    data[i] = Math.max(data[i], data[j] + 1);
                }
            }
            max = Math.max(max, data[i]);
        }
        return max;
    }
}
