package Q101TO150.number122;

/**
 * @author: Bright Chan
 * @date: 2020/11/8 11:17
 * @description: 贪心算法；动态规划
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int cur = prices[i], next = prices[i + 1];
            if (cur < next) {
                int tmp = i + 1;
                while (tmp < prices.length && prices[tmp] > prices[tmp - 1]) tmp++;
                tmp--;

                maxProfit += prices[tmp] - cur;

                i = tmp;
            }
        }
        return maxProfit;
    }
}
