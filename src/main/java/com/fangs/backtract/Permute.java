package com.fangs.backtract;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @author fangs
 */
public class Permute {

    //写一个测试以下全排列的main方法
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute p = new Permute();
        List<List<Integer>> res = p.permute(nums);
        System.out.println(res);
    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> data = new LinkedList<>();
        backtract(data, nums);
        return res;
    }

    public void backtract(LinkedList<Integer> data, int[] nums) {
        if (data.size() == nums.length) {
            res.add(new ArrayList<>(data));
        }
        for (int num : nums) {
            if (data.contains(num)) {
                continue;
            }
            data.add(num);
            backtract(data, nums);
            data.removeLast();
        }
    }

}
