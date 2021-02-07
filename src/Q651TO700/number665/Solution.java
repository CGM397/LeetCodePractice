package Q651TO700.number665;

/**
 * @author: Bright Chan
 * @date: 2021/2/7 9:55
 * @description: 数组
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length, left = 0, right = 1;
        if (len == 1) return true;

        while (right < len) {
            if (nums[left] <= nums[right]) {
                left++;
                right++;
            }
            else break;
        }

        if (right < len - 1) {
            int cur = nums[right + 1];
            if (cur < nums[left] && cur >= nums[right]) {
                if (left > 0) {
                    if (nums[left - 1] > nums[right]) return false;
                }
            }
            else if (cur < nums[right]) {
                return false;
            }
            left++;
            right++;
            while (right < len) {
                if (nums[left] <= nums[right]) {
                    left++;
                    right++;
                }
                else return false;
            }
        }
        return true;
    }
}
