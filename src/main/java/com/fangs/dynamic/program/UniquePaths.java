package com.fangs.dynamic.program;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/unique-paths">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }

    /**
     * 动态规划
     * 状态转移方程，当前位置的方案数=下面一块的方案数+右边一块的方案数
     * 并且在终点任意同边的块方案数为1
     *
     * @param m 网格高
     * @param n 网格宽
     * @return 从左上角到左下角的方案数
     * @author fangs
     */
    public int uniquePaths(int m, int n) {
        if (m < 2 && n < 2) {
            return 1;
        }
        int[][] data = new int[m][n];
        for (int i = 0; i < m; i++) {
            data[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            data[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                data[i][j] = data[i][j - 1] + data[i - 1][j];
            }
        }
        //辅助，打印矩阵
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (data[i][j] < 10) {
//                    System.out.print(" ");
//                }
//                System.out.print(data[i][j] + " ");
//            }
//            System.out.println();
//        }
        return data[m - 1][n - 1];
    }
}
