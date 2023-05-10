package com.fangs.dynamic.program;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class Subsequence {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgc";
        Subsequence subsequence = new Subsequence();
        System.out.println(subsequence.isSubsequence(s, t));
        System.out.println(subsequence.isSubsequence2(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int jj = 0;
        outer:
        for (int i = 0; i < sCharArray.length; i++) {
            for (int j = jj; j < tCharArray.length; j++) {
                if (sCharArray[i] == tCharArray[j]) {
                    //找到后，标记当前完整字符串中的指针，进入下一个字符的匹配
                    jj = ++j;
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }

    /**
     * 官方-动态规划
     *
     * @param s
     * @param t
     * @return
     * @author fangs
     */
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        System.out.println(t);
        StringJoiner letter = new StringJoiner(" ");
        letter.add("---");
        for (int i = 0; i < 26; i++) {
            char tt = (char) (i + 'a');
            letter.add(Character.toString(tt));
        }
        System.out.println(letter);
        for (int i = 0; i < f.length; i++) {
            int[] ints = f[i];
            StringJoiner stringJoiner = new StringJoiner(" ");
            stringJoiner.add(Integer.toString(i)).add(":");
            for (int anInt : ints) {
                stringJoiner.add(Integer.toString(anInt));
            }
            System.out.println(stringJoiner);
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
