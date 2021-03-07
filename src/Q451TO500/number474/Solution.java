package Q451TO500.number474;

/**
 * @author: Bright Chan
 * @date: 2021/3/6 15:35
 * @description: 动态规划
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    String cur = strs[i - 1];
                    int oneCount = 0, zeroCount = 0;
                    for (char c : cur.toCharArray()) {
                        if (c == '0') zeroCount++;
                        else oneCount++;
                    }
                    if (zeroCount <= j && oneCount <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroCount][k - oneCount] + 1);
                    }
                    else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[len][m][n];
    }
}
