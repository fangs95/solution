package com.fangs.dynamic.program;

/**
 * 1025. 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < n 且 n % x == 0 。
 * 用 n - x 替换黑板上的数字 n 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/divisor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fangs
 */
public class DivisorGame {
    public boolean divisorGame(int n) {
        if (n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        }
        boolean[] res = new boolean[n + 1];
        res[1] = false;
        res[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //只要找到一个满足条件且对方必输的状态就算赢
                if (i % j == 0 && !res[i - j]) {
                    //标记i起手 可赢
                    res[i] = true;
                    break;
                }
            }
            //遍历结束还没找到则表示i起手必输
        }
        return res[n];
    }
}
