package Q1801TO1850.number1833;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/7/2 22:54
 * @description: 排序
 */
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int res = 0;
        for (int one : costs) {
            if (coins < one) return res;
            else {
                coins -= one;
                res++;
            }
        }
        return res;
    }
}
