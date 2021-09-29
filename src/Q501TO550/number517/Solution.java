package Q501TO550.number517;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/9/29 16:20
 * @description: 贪心
 */
public class Solution {
    public int findMinMoves(int[] machines) {
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}
