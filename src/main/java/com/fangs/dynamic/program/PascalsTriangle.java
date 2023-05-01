package com.fangs.dynamic.program;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author fangs
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        List<List<Integer>> generate = p.generate2(10);
        for (List<Integer> list : generate) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : list) {
                stringBuilder.append(integer).append("-");
            }
            System.out.println(stringBuilder);
        }
    }

    /**
     * 依据杨辉三角定义逐行计算即可
     *
     * @param numRows 杨辉三角行数
     * @return 杨辉三角数组
     * @author fangs
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
            } else {
                List<Integer> lastRow = triangle.get(triangle.size() - 1);
                int rowNum = lastRow.size() + 1;
                for (int j = 0; j < rowNum; j++) {
                    int t;
                    if (j == 0 || j >= lastRow.size()) {
                        t = 1;
                    } else {
                        t = lastRow.get(j - 1) + lastRow.get(j);
                    }
                    row.add(t);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }

    /**
     * 数学算法：
     * 观察杨辉三角每行的规律可发现，他的每行可表示为二项式的展开项
     * 如：(a+b)^5 可展开为 a^2+5a^4*b+10a^3*b^2+10a^2*b^3+5ab^4+b^5
     * 即：1 5 10 10 5 1
     * 所以我们可以用二项式的通项公式来计算任意行任意列的数字
     * 如(a+b)^n的通项公式为：n!/m!(n-m)! m可以理解为每项b的幂
     * 通过该公式我们可得通项式的邻里公式为
     * 当前项=前一项*（n-m+1）/m
     *
     * @param numRows
     * @return
     * @author fangs
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            int last = 0;
            for (int i1 = 0; i1 < (i + 1); i1++) {
                if (i1 == 0) {
                    last = 1;
                } else {
                    last = last * (i - i1 + 1) / i1;
                }
                row.add(last);
            }
            triangle.add(row);
        }
        return triangle;
    }
}
