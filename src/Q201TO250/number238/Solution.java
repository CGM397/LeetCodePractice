package Q201TO250.number238;

/**
 * @author: Bright Chan
 * @date: 2021/3/29 14:26
 * @description: 数组
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[1] = nums[0];
        int[] postSum = new int[n];
        postSum[n - 2] = nums[n - 1];
        for (int i = 2; i < n; i++) {
            preSum[i] = preSum[i - 1] * nums[i - 1];
        }
        for (int i = n - 3; i >= 0; i--) {
            postSum[i] = postSum[i + 1] * nums[i + 1];
        }

        int[] res = new int[n];
        res[0] = postSum[0];
        res[n - 1] = preSum[n - 1];
        for (int i = 1; i < n - 1; i++) {
            res[i] = preSum[i] * postSum[i];
        }
        return res;
    }
}
