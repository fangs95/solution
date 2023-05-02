package com.fangs.dynamic.program;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列  Tn  定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0  的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数  n，请返回第 n 个泰波那契数  Tn 的值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class Tribonacci {
    public int tribonacci(int n) {
        int[] tribonacci;
        if (n < 2) {
            tribonacci = new int[3];
        } else {
            tribonacci = new int[n + 1];
        }
        tribonacci[0] = 0;
        tribonacci[1] = 1;
        tribonacci[2] = 1;
        for (int i = 3; i < tribonacci.length; i++) {
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
        }
        return tribonacci[n];
    }
}
