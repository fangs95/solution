package com.fangs.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/contains-duplicate-ii">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        boolean b = new ContainsNearbyDuplicate().containsNearbyDuplicate(nums, 2);
        System.out.println(b);
    }


    /**
     * 滑动窗口
     *
     * @param nums
     * @param k
     * @return
     * @author fangs
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        int left = 0, right = 0;
        while (left < nums.length) {
            while (right < nums.length) {
                if (hash.containsKey(nums[right])) {
                    return true;
                }
                hash.put(nums[right], right);
                if (right - left < k) {
                    right++;
                } else {
                    break;
                }
            }
            if (right - left >= k) {
                hash.remove(nums[left]);
                left++;
                right++;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 优化：该题的k已经限制了滑动窗口的大小，所以不必使用双指针维护窗口大小
     * hashMap可以用set优化
     *
     * @param nums
     * @param k
     * @return
     * @author fangs
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.add(nums[i])) {
                return true;
            }
            if (i >= k) {
                hash.remove(nums[i - k]);
            }
        }
        return false;
    }
}
