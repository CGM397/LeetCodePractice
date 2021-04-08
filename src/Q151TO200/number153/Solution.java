package Q151TO200.number153;

/**
 * @author: Bright Chan
 * @date: 2021/4/8 10:45
 * @description: 二分
 */
public class Solution {
    public int findMin(int[] nums) {
        int start = nums[0];

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int cur = nums[mid];
            if (mid == 0) return Math.min(cur, nums[mid + 1]);
            else {
                if (nums[mid - 1] > cur) return cur;
                else {
                    if (cur > start) left = mid + 1;
                    else right = mid - 1;
                }
            }
        }
        return Math.min(nums[left], start);
    }
}
