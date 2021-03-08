package Q1451TO1500.number1458;

/**
 * @author: Bright Chan
 * @date: 2021/3/7 16:40
 * @description: TODO
 */
public class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = nums1[i] * nums2[j];
                dp[i][j] = tmp;
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + tmp, dp[i][j]);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
