package Q101TO150.number123;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/1/11 10:33
 * @description: 动态规划
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;

        // 2次交易：0到2
        int[][] buy = new int[len][3];
        int[][] sell = new int[len][3];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= 2; i++) {
            buy[0][i] = Integer.MIN_VALUE / 2;
            sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < len; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= 2; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[len - 1]).max().getAsInt();
    }
}
