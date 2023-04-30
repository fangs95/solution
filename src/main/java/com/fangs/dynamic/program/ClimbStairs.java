package com.fangs.dynamic.program;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author fangs
 */
public class ClimbStairs {
    /**
     * 动态规划
     *
     * @param n 解题数
     * @return 走法树
     * @author fangs
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }


    /**
     * leetcode官方解法：矩阵快速幂
     * 题解地址：https://leetcode.cn/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
     *
     * @param n
     * @return
     * @author fangs
     */
    public int climbStairs2(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }


    /**
     * 斐波那契数列 通项公式
     *
     * @param n
     * @return
     * @author fangs
     */
    public int climbStairs3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }

}
