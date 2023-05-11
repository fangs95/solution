package com.fangs.dynamic.program;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LCP 07. 传递信息
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/chuan-di-xin-xi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class NumWays {
    /**
     * 动态规划解题思路：
     * 对步数循环，分别记下那些成员可以1步到终点，2步到终点
     * 本步到终点的方案数 = data[上一步][下一步能传的成员]累加
     *
     * @param n
     * @param relation
     * @param k
     * @return
     * @author fangs
     */
    public int numWays(int n, int[][] relation, int k) {
        int[][] data = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < relation.length; j++) {
                int[] toData = relation[j];
                if (i == 0) {
                    if (toData[1] == n - 1) {
                        data[i][toData[0]] = 1;
                    }
                } else {
                    data[i][toData[0]] += data[i - 1][toData[1]];
                }

            }
        }
        return data[k - 1][0];
    }
}
