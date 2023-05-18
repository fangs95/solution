package com.fangs.dynamic.program;

import java.util.*;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author fangs
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis a = new GenerateParenthesis();
        List<String> strings = a.generateParenthesis(3);
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String string : strings) {
            stringJoiner.add(string);
        }
        System.out.println("答案：");
        System.out.println(stringJoiner.toString());
    }

    /**
     * 暴力法：穷举所有可能最后判断出有效的
     * <p>
     * 优化：
     * 方法一还有改进的余地：我们可以只在序列仍然保持有效时才添加
     * ‘(’
     * ‘(’ 或
     * ‘)’
     * ‘)’，而不是像 方法一 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     * <p>
     * 如果左括号数量不大于
     * �
     * n，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     * @author fangs
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        add(new StringBuilder(), '(', n, 1, 0, res);
        return res;
    }

    void add(StringBuilder a, char c, int n, int open, int close, List<String> res) {
        a.append(c);
        if (a.length() == 2 * n) {
//            if (check(a.toString())) {
            res.add(a.toString());
//            }
            return;
        }
        if (open < n) {
            int newOpen = open;
            add(a, '(', n, ++newOpen, close, res);
            a.deleteCharAt(a.length() - 1);
        }
        if (close < open) {
            int newClose = close;
            add(a, ')', n, open, ++newClose, res);
            a.deleteCharAt(a.length() - 1);
        }
    }

    /**
     * 暴力法用该方法检查字符串是否合法
     *
     * @param a 字符串
     * @return 合法 true，否则 false
     * @author fangs
     */
    boolean check(String a) {
        Deque<Character> queue = new LinkedList<>();
        char[] charArray = a.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                queue.push(charArray[i]);
            } else {
                if (queue.size() == 0) {
                    return false;
                }
                queue.pop();
            }
        }
        if (queue.size() > 0) {
            return false;
        }
        return true;
    }
}
