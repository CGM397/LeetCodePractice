package Q601TO650.number643;

/**
 * @author: Bright Chan
 * @date: 2021/2/4 9:50
 * @description: 滑动窗口
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int left = 0, right = k - 1, len = nums.length;
        double res = sum / k;
        while (right < len - 1) {
            sum -= nums[left++];
            sum += nums[++right];
            double tmp = sum / k;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
