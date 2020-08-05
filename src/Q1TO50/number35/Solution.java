package Q1TO50.number35;

/**
 * @author: Bright Chan
 * @date: 2020/8/5 11:22
 * @description: 二分查找
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length < 1) return 0;
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid]) {
                    high = mid - 1;
                    if (high < low)
                        return low;
                }
            else {
                low = mid + 1;
                if (low > high)
                    return low;
            }
        }
        return 0;
    }
}
