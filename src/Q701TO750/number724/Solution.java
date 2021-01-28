package Q701TO750.number724;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/1/28 10:34
 * @description: 数组
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 1) return -1;

        int totalSum = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == (totalSum - nums[i]) / 2.0) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
