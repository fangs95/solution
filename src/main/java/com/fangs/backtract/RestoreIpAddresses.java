package com.fangs.backtract;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * @author fangs
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        //25525511135
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> strings = restoreIpAddresses.restoreIpAddresses("25525511135");
        strings.forEach(System.out::println);
    }

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, new ArrayList<>());
        return res;
    }

    /**
     * 回溯算法
     *
     * @param s
     * @param data
     * @return
     * @author fangs
     */
    public String restoreIpAddresses(String s, List<String> data) {
        if (data.size() == 4) {
            if (s.isEmpty()) {
                StringJoiner stringJoiner = new StringJoiner(".");
                data.forEach(stringJoiner::add);
                return stringJoiner.toString();
            } else {
                return null;
            }
        }
        for (int i = 1; i <= 3; i++) {
            if (i > s.length()) {
                break;
            }
            String one = s.substring(0, i);
            if (checkOne(one)) {
                data.add(one);
                String resStr = s.substring(i);
                if (!check(s, data)) {
                    break;
                }
                String ans = restoreIpAddresses(resStr, data);
                if (ans != null) {
                    res.add(ans);
                }
                //撤回
                data.remove(data.size() - 1);
            }
        }
        return null;
    }

    private boolean checkOne(String s) {
        if (s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }

    private boolean check(String s, List<String> data) {
        return (4 - data.size()) * 3 >= s.length();
    }

}
