package com.fangs.dynamic.program;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * @author fangs
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "ababababababa";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }

    /**
     * 动态规划：先找到字符串中的最小回文，然后使用双指针扩大回文范围
     *
     * @param s 字符串参数
     * @return 最大回文串
     * @author fangs
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int[] LPIndex = new int[2];
        int[] index = new int[2];
        boolean isFind = true;
        for (int i = 1; i < charArray.length; i++) {
            boolean isOnce = true;
            int a = i;
            while (a < charArray.length && charArray[a] == charArray[a - 1]) {
                isFind = false;
                if (isOnce) {
                    index[0] = a - 1;
                    isOnce = false;
                }
                index[1] = a;
                a++;
            }
            if (i > 1 && index[1] - index[0] < 2 && charArray[i] == charArray[i - 2]) {
                isFind = false;
                index[0] = i - 2;
                index[1] = i;
            }
            while (!isFind) {
                if (index[0] > 0 && index[1] < charArray.length - 1 && charArray[index[1] + 1] == charArray[index[0] - 1]) {
                    index[0] = index[0] - 1;
                    index[1] = index[1] + 1;
                } else {
                    isFind = true;
                    if (index[1] - index[0] > LPIndex[1] - LPIndex[0]) {
                        LPIndex = index;
                    }
                    index = new int[]{0, 0};
                }
            }

        }
        if (index[1] - index[0] > LPIndex[1] - LPIndex[0]) {
            LPIndex = index;
        }
        return new String(charArray, LPIndex[0], LPIndex[1] - LPIndex[0] + 1);
    }
}
