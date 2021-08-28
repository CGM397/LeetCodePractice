package Q1451TO1500.number1480;

/**
 * @author: Bright Chan
 * @date: 2021/8/28 23:13
 * @description: 数组
 */
public class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
