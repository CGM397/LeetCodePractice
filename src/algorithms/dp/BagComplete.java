package algorithms.dp;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/3/6 14:39
 * @description: 完全背包问题
 */
public class BagComplete {
    public int solution(int[] v, int[] w, int V) {
        int len = v.length;
        int[][] dp = new int[len + 1][V + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < V; i++) {
            dp[i][0] = 0;
        }

        // 前 i - 1 件物品放入容量为j的背包的最优解
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= V; j++) {
                // 第 i - 1 件物品放入容量为j的背包里，最多可以放maxNum个
                int maxNum = j / v[i - 1];
                dp[i][j] = 0;
                for (int k = 0; k <= maxNum; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i - 1]] + k * w[i - 1]);
                }
            }
        }
        return dp[len][V];
    }
}
