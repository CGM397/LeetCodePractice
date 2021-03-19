package Q151TO200.number198;

/**
 * @author: Bright Chan
 * @date: 2021/3/18 16:07
 * @description: 动态规划
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        // 到第i家时，获取的最大利益
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length < 2) return dp[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
