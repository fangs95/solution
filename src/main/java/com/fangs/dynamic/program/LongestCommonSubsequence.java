package com.fangs.dynamic.program;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * @author fangs
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        LongestCommonSubsequence demo = new LongestCommonSubsequence();

        System.out.println(demo.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] data = new int[m + 1][n + 1];
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        for (int i = 0; i < charArray1.length; i++) {
            for (int j = i; j < charArray2.length; j++) {
                if (charArray1[i] == charArray2[j]) {
                    data[i + 1][j + 1] = data[i][j] + 1;
                } else {
                    data[i + 1][j + 1] = Math.max(data[i][j + 1], data[i + 1][j]);
                }
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
