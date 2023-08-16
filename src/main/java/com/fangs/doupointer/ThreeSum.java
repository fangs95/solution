package com.fangs.doupointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> lists = threeSum.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int s = i + 1;
            int e = nums.length - 1;
            for (; ; ) {
                if ((nums[i] + nums[s] + nums[e]) == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[s]);
                    item.add(nums[e]);
                    res.add(item);
                    do {
                        s++;
                    } while (e > s && nums[s] == nums[e - 1]);
                } else if ((nums[i] + nums[s] + nums[e]) > 0) {
                    do {
                        e--;
                    } while (e > s && nums[e] == nums[e + 1]);
                } else {
                    do {
                        s++;
                    } while (e > s && nums[s] == nums[e - 1]);
                }
                if (s >= e) {
                    break;
                }
            }
        }
        return res;
    }
}
