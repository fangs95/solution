package com.fangs.dynamic.program;


/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * @author fangs
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] a = {-2, -1, -3};
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(a);
        System.out.println(i);
    }

    /**
     * 思路：
     * 我们需要找出累加的边界
     * 如果sum大于等于0肯定要连续累加
     * sum小于0时，如果num是大于sum的数则结束累加，重新从num开始累加
     *
     * @param nums
     * @return
     * @author fangs
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            if (sum < 0 && sum < num) {
                sum = num;
                if (max < sum) {
                    max = sum;
                }
                continue;
            }
            sum += num;
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
