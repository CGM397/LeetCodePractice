package Q201TO250.number213;

/**
 * @author: Bright Chan
 * @date: 2021/3/18 16:12
 * @description: 动态规划；环形问题可以简化为两个线性问题
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length < 2) return nums[0];

        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }

        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }
}
