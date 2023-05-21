package com.fangs.dynamic.program;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 9, 20, 23};
        System.out.println(new Jump().jump2(nums));
    }

    /**
     * 动态规划：遍历时保存，遍历过元素的最小步数，当前元素到终点距离为 可达元素的最小距离加1
     * 该题最优解为贪心算法，动态规划效率过低
     *
     * @param nums
     * @return
     * @author fangs
     */
    public int jump(int[] nums) {
        int[] mins = new int[nums.length];
        Arrays.fill(mins, nums.length);
        mins[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                if (mins[i] > mins[i + j] + 1) {
                    mins[i] = mins[i + j] + 1;
                }
            }
        }
        return mins[0];
    }


    /**
     * 官方贪心算法
     * 每个元素都尽可能跳到最远的元素
     *
     * @param nums
     * @return
     * @author fangs
     */
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
