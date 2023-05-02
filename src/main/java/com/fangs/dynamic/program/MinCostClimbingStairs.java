package com.fangs.dynamic.program;

/**
 * 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] p = {10, 15, 20};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int i = minCostClimbingStairs.minCostClimbingStairs(p);
        System.out.println(i);
    }

    /**
     * 计算出到达第i级台阶的最小花费，依次往上计算
     * 转移方程为 f(i)=min(f(i-1)+cost(i-1),f(i-2)+cost(i-2));
     *
     * @param cost
     * @return
     * @author fangs
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length + 1];
        for (int i = 2; i < res.length; i++) {
            res[i] = Math.min(res[i - 2] + cost[i - 2], res[i - 1] + cost[i - 1]);
        }
        return res[res.length - 1];
    }
}
