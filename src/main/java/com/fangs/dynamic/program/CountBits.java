package com.fangs.dynamic.program;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * @author fangs
 */
public class CountBits {
    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        for (int i : countBits.countBits2(5)) {
            System.out.println(i);
        }
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int t = i;
            while (t > 0) {
                ans[i]++;
                t &= (t - 1);
            }
        }
        return ans;
    }

    /**
     * 对比特数进行分析可知，如果一个数刚好的2的多少次幂则该数的比特位只有1个1，我们称这样的数为1比特数
     * 比1比特数大1的数 的1的个数应该是+1的关系，依次类推，我们从小到大遍历 ans数组中用从0到i的所有比特数
     * 我们只要找到小于等于i的最大1比特数，然后用 i-最大1比特数+1就可以得到  i的比特数中1的个数
     * 官方题解：https://leetcode.cn/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode-solution-0t1i/
     *
     * @param n
     * @return
     * @author fangs
     */
    public int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        int high = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                ans[i] = 1;
                high = i;
            } else {
                ans[i] = ans[i - high] + 1;
            }
        }
        return ans;
    }

}
