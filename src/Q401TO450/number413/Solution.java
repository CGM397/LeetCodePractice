package Q401TO450.number413;

/**
 * @author: Bright Chan
 * @date: 2021/8/10 21:02
 * @description: 滑动窗口
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int left = 0, right = 1, len = nums.length, delta = nums[1] - nums[0], res = 0;
        while (right < len) {
            if (nums[right] - nums[right - 1] != delta) {
                res += right - 1 - left >= 2 ? getRes(right - left - 2) : 0;
                left = right - 1;
                delta = nums[right] - nums[right - 1];
            }
            right++;
        }

        res += right - 1 - left >= 2 ? getRes(right - left - 2) : 0;
        return res;
    }

    private int getRes(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }
}
