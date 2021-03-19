package Q501TO550.number518;

/**
 * @author: Bright Chan
 * @date: 2021/3/18 15:40
 * @description: 动态规划
 */
public class Solution {
    public int change(int amount, int[] coins) {

        // 总价值为 i 的方法数
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
