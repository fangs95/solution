package com.fangs.dynamic.program;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 * @author fangs
 */
public class LongestPalindrome2 {

    /**
     * 回文串必然是偶数个字符和 一个多余的1个字符
     *
     * @param s
     * @return
     * @author fangs
     */
    public int longestPalindrome(String s) {
        int[] data = new int[128];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int i = data[c];
            data[c] = ++i;
        }
        int d = 0;
        boolean flag = false;
        for (int datum : data) {
            if (datum % 2 == 1) {
                if (!flag) {
                    flag = true;
                }
                d += (datum - 1);
            } else {
                d += datum;
            }
        }
        if (flag) {
            d++;
        }
        return d;
    }
}
