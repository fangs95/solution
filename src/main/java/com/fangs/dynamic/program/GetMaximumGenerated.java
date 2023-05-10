package com.fangs.dynamic.program;

/**
 * 1646. 获取生成数组中的最大值
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/get-maximum-in-generated-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class GetMaximumGenerated {

    /**
     * 动态规划
     * 根据题意，可得状态转移方程如下：
     * x>2时，
     * x为偶数时，f(x) = f(x/2)
     * x为奇数时，f(x) = f((x-1)/2) + f((x-1)/2+1)
     *
     * @param n x的最大值
     * @return 数组中的最大值
     * @author fangs
     */
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                int t = i / 2;
                nums[i] = nums[t] + nums[t + 1];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
