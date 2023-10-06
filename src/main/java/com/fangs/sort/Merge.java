package com.fangs.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @author fangs
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (ans.size() == 0 || (ans.get(ans.size() - 1)[1] < intervals[i][0])) {
                ans.add(intervals[i]);
            } else {
                if (ans.get(ans.size() - 1)[1] < intervals[i][1]) {
                    ans.get(ans.size() - 1)[1] = intervals[i][1];
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
