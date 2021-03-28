package Q101TO150.number121;

/**
 * @author: Bright Chan
 * @date: 2021/3/26 19:17
 * @description: 数组
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], res = 0;

        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            if (cur < min) {
                min = cur;
            }
            if (cur > min) {
                res = Math.max(res, cur - min);
            }
        }
        return res;
    }
}
