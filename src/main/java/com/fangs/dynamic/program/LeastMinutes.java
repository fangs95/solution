package com.fangs.dynamic.program;

/**
 * LCS 01. 下载插件
 * 小扣打算给自己的 VS code 安装使用插件，初始状态下带宽每分钟可以完成 1 个插件的下载。假定每分钟选择以下两种策略之一:
 * <p>
 * 使用当前带宽下载插件
 * 将带宽加倍（下载插件数量随之加倍）
 * 请返回小扣完成下载 n 个插件最少需要多少分钟。
 * <p>
 * 注意：实际的下载的插件数量可以超过 n 个
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/Ju9Xwi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class LeastMinutes {
    /**
     * 我们先列出每加一分钟能下载的最大插件数量
     * 1分钟：1
     * 2分钟：2
     * 3分钟：4
     * 4分钟：8
     * 5分钟：16
     * 可得：maxN=2^(t-1)
     *
     * @param n 下载插件数量
     * @return 最少需要多少分钟
     * @author fangs
     */
    public int leastMinutes(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int min = 2;
        while (n > Math.pow(2, min - 1)) {
            min++;
        }
        return min;
    }
}
