package algorithms.dp;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/3/6 11:17
 * @description: 01背包问题
 */
public class Bag01 {
    public int solution(int[] v, int[] w, int V) {
        int len = v.length;
        int[][] dp = new int[len + 1][V + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < V; i++) {
            dp[i][0] = 0;
        }

        // 前 i 件（下标为 i - 1）物品放入容量为 j 的背包的最优解
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= v[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i - 1]] + w[i - 1]);
                }
                else {
                    // 第 i 件物品的体积大于j，所以不会将它放入
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][V];
    }
}
