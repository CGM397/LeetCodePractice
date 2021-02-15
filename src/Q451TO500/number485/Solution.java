package Q451TO500.number485;

/**
 * @author: Bright Chan
 * @date: 2021/2/15 11:13
 * @description: 数组
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, count = 0, right = 0, len = nums.length;

        while (right < len) {
            if (nums[right] == 1) count++;
            else {
                res = Math.max(res, count);
                count = 0;
            }
            right++;
        }
        return Math.max(res, count);
    }
}
