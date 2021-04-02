package Q251TO300.number279;

/**
 * @author: Bright Chan
 * @date: 2021/3/29 15:30
 * @description: dp
 */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int max = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= max; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
