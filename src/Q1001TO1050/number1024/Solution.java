package Q1001TO1050.number1024;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/10/24 10:20
 * @description: 贪心；动态规划
 */
public class Solution {

    // official solution : dp
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    public int mySlowMethod(int[][] clips, int T) {
        // sort
        for (int i = 0; i < clips.length - 1; i++) {
            for (int j = i + 1; j < clips.length; j++) {
                if (clips[i][0] > clips[j][0]) {
                    int[] tmp = clips[i];
                    clips[i] = clips[j];
                    clips[j] = tmp;
                }
            }
        }

        int start = 0, end = 0, searchIndex = 0, res = 0;
        while (end < T) {
            int maxLen = -1;
            boolean first = true;
            for (int i = searchIndex; i < clips.length; i++) {
                int x = clips[i][0], y = clips[i][1];
                if (x < start) continue;
                if (x <= end) {
                    if (x > start && first) {
                        first = false;
                        searchIndex = i;
                    }
                    if (y > end && y > maxLen) {
                        maxLen = y;
                    }
                }
                if (x > end) break;
            }
            if (maxLen == -1) return -1;

            res++;
            start = end + 1;
            end = maxLen;
        }

        return res;
    }
}
