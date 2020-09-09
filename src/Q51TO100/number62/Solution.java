package Q51TO100.number62;

/**
 * @author: Bright Chan
 * @date: 2020/9/7 16:54
 * @description: 简单回溯会超时，要用动态规划
 */
public class Solution {

    private int res = 0;
    public int myUniquePaths(int m, int n) {
        dfs(0, 0, m, n);
        return res;
    }

    private void dfs(int x, int y, int m, int n) {
        if (x == m - 1 && y == n - 1) {
            res++;
            return;
        }

        if (x < m - 1) dfs(x + 1, y, m, n);
        if (y < n - 1) dfs(x, y + 1, m, n);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
