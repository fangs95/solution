package com.fangs.sliding.window;

/**
 * 1763. 最长的美好子字符串
 * 当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
 * <p>
 * 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-nice-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class LongestNiceSubstring {
    public static void main(String[] args) {
        System.out.println(1 << ('a' - 'a'));
        System.out.println(new LongestNiceSubstring().longestNiceSubstring("HkhBubUYy"));
    }

    public String longestNiceSubstring(String s) {
        if (s.length() <= 1) {
            return "";
        }
        char[] ss = s.toCharArray();
        //不断缩小窗口长度
        for (int i = s.length(); i >= 2; i--) {
            //滑动窗口
            for (int j = 0; j <= s.length() - i; j++) {
                //检查字符串是否符合要求
                int a = 0;
                int b = 0;
                for (int z = j; z < i + j; z++) {
                    if (ss[z] > 96) {
                        //小写
                        a |= (1 << (ss[z] - 'a'));
                    } else {
                        //大写
                        b |= (1 << (ss[z] - 'A'));
                    }
                }
                int c = a & b;
                System.out.println("当前字符串：" + s.substring(j, j + i));
                System.out.println(Integer.toBinaryString(a));
                System.out.println(Integer.toBinaryString(b));
                System.out.println(Integer.toBinaryString(c));
                if (c == a && c == b) {
                    return s.substring(j, j + i);
                }
            }
        }
        return "";
    }
}
