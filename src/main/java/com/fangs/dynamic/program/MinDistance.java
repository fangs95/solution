package com.fangs.dynamic.program;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * @author fangs
 */
public class MinDistance {

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        int[][] data = new int[m + 1][n + 1];
        //设定边界值
        for (int i = 0; i <= m; i++) {
            data[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            data[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int top = data[i - 1][j] + 1;
                int left = data[i][j - 1] + 1;
                int topLeft = data[i - 1][j - 1];
                if (char1[i - 1] != char2[j - 1]) {
                    topLeft++;
                }
                data[i][j] = Math.min(top, Math.min(left, topLeft));
            }
        }
        for (int[] datum : data) {
            for (int i : datum) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
        return data[m][n];
    }

}
