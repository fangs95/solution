package com.fangs.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author fangs
 */
public class SpiralOrder {

    //    写一个54. 螺旋矩阵的测试main方法
    public static void main(String[] args) {
        int[][] matrix = {
                {3},
                {2}
        };
        SpiralOrder s = new SpiralOrder();
        List<Integer> res = s.spiralOrder(matrix);
        System.out.println(res);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> data = new ArrayList<>();
        search(data, matrix, 0, 0, 0);
        return data;
    }

    /**
     * 从matrix的第一个元素开始，按照顺时针方向遍历
     *
     * @param data
     * @param matrix
     * @param direction 方向 0右 1下 2左 3上
     * @author fangs
     */
    public void search(List<Integer> data, int[][] matrix, int direction, int x, int y) {
        int rl = matrix.length;
        int cl = matrix[0].length;
        data.add(matrix[y][x]);
        matrix[y][x] = Integer.MAX_VALUE;
        switch (direction) {
            case 0:
                if (x == (cl - 1) || matrix[y][x + 1] == Integer.MAX_VALUE) {
                    direction = turn(direction);
                }
                break;
            case 1:
                if (y == (rl - 1) || matrix[y + 1][x] == Integer.MAX_VALUE) {
                    direction = turn(direction);
                }
                break;
            case 2:
                if (x == 0 || matrix[y][x - 1] == Integer.MAX_VALUE) {
                    direction = turn(direction);
                }
                break;
            case 3:
                if (y == 0 || matrix[y - 1][x] == Integer.MAX_VALUE) {
                    direction = turn(direction);
                }
                break;
        }
        switch (direction) {
            case 0:
                x++;
                break;
            case 1:
                y++;
                break;
            case 2:
                x--;
                break;
            case 3:
                y--;
                break;
        }
        if (x < 0 || y < 0 || x >= cl || y >= rl || matrix[y][x] == Integer.MAX_VALUE) {
            return;
        }
        search(data, matrix, direction, x, y);
    }


    public int turn(int direction) {
        if (direction != 3) {
            return ++direction;
        } else {
            return 0;
        }
    }
}
