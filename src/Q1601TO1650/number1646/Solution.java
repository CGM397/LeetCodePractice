package Q1601TO1650.number1646;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/8/23 21:26
 * @description: 模拟
 */
public class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
