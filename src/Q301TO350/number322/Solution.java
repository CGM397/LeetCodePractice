package Q301TO350.number322;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/3/18 15:56
 * @description: 动态规划
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {

        // 达到 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        return dp[amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
