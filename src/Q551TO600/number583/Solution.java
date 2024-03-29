package Q551TO600.number583;

/**
 * @author: Bright Chan
 * @date: 2021/9/25 18:04
 * @description: dp
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int maxSubSeq = maxSubSeq(word1, word2);

        return word1.length() - maxSubSeq + word2.length() - maxSubSeq;
    }

    private int maxSubSeq(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
