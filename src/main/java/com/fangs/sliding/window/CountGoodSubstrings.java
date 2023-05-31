package com.fangs.sliding.window;

/**
 * 1876. 长度为三且各字符不同的子字符串
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 * <p>
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 * <p>
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * <p>
 * 子字符串 是一个字符串中连续的字符序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/substrings-of-size-three-with-distinct-characters">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class CountGoodSubstrings {

    public static void main(String[] args) {
        System.out.println(new CountGoodSubstrings().countGoodSubstrings("aababcabc"));
    }

    /**
     * 窗口大小固定为3的滑动窗口算法
     *
     * @param s 字符串
     * @return 完美子字符串的个数
     * @author fangs
     */
    public int countGoodSubstrings(String s) {
        if (s == null || s.length() < 3) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = 2; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                i++;
            } else {
                if (chars[i] != chars[i - 1] && chars[i - 1] != chars[i - 2] && chars[i] != chars[i - 2]) {
                    num++;
                }
            }

        }
        return num;
    }

}
