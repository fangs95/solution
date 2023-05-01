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
        List<List<Integer>> generate = p.generate(10);
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
}
