package com.fangs.sort;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author fangs
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] p = {123, 23, 632, 1, 12, 345, 3, 7, 4, 1, 67, 15, 43};
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(p, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }

}
