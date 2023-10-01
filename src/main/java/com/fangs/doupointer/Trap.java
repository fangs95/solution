package com.fangs.doupointer;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author fangs
 */
public class Trap {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ans = 0;
        int lmax = height[0];
        int rmaxIndex = this.getMaxHeight(height, 0);
        for (int i = 1; i < height.length - 1; i++) {
            if (rmaxIndex <= i) {
                rmaxIndex = this.getMaxHeight(height, i);
            }
            if (height[i] > lmax) {
                lmax = height[i];
            } else if (height[i] < height[rmaxIndex]) {
                int high = Math.min(lmax, height[rmaxIndex]);
                ans += (high - height[i]);
            }
        }
        return ans;
    }

    private int getMaxHeight(int[] height, int index) {
        int max = height[index + 1];
        int maxIndex = index + 1;
        for (int i = index + 1; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
