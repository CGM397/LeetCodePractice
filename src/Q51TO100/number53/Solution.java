package Q51TO100.number53;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 11:06
 * @description: 动态规划
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int i = 0;

        int start = i, sum, res = nums[0];
        for (; i < nums.length; i++) {
            if (i != start && nums[i - 1] > 0) continue;

            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > res) res = sum;
            }
        }

        return res;
    }

    public int dp(int[] nums) {
        int pre = 0, res = nums[0];

        for (int num : nums) {
            //状态转移方程
            pre = Math.max(pre + num, num);

            res = Math.max(res, pre);
        }

        return res;
    }
}
