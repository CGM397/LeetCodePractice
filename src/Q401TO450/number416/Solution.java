package Q401TO450.number416;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/10/11 9:03
 * @description: 动态规划
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i : nums) totalSum += i;

        if (totalSum % 2 != 0) return false;

        int halfSum = totalSum / 2;
        Arrays.sort(nums);

        // 如果最大的元素值大于halfSum，则直接返回false
        if (nums[nums.length - 1] > halfSum) return false;

        // init dp array
        // dp[i][j]: 0~i的数字是否可以选取某个子集，使其和为j
        // 可简化为一维数组
        boolean[][] dp = new boolean[nums.length][halfSum + 1];
        for (boolean[] one : dp) Arrays.fill(one, false);
        for (int i = 0; i < nums.length; i++) dp[i][0] = true;
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < halfSum + 1; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][halfSum];
    }
}
