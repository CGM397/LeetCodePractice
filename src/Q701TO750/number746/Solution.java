package Q701TO750.number746;

/**
 * @author: Bright Chan
 * @date: 2020/12/21 10:16
 * @description: 动态规划
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        // 到最后一个台阶的时候还要往上走一步，所以可以不踩最后一个台阶，从倒数第二个台阶直接跨上去
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
