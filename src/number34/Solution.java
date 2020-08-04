package number34;

/**
 * @author: Bright Chan
 * @date: 2020/8/4 17:28
 * @description: 二分查找
 */
public class Solution {
    private int left = -1, right = -1, firstPos = -1;
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length < 1) return res;
        left = nums.length;
        search(nums, 0, nums.length - 1, target);
        if (left == nums.length && right == -1)
            return res;
        else {
            res[0] = left;
            res[1] = right;
            return res;
        }
    }

    //逻辑有一点点混乱，但是耗时很小 :)
    private void search(int[] nums, int low, int high, int target) {
        if (low > high) return;
        int mid = low + (high - low) / 2;
        if (target == nums[mid]) {
            if (mid > right)
                right = mid;
            if (mid < left)
                left = mid;

            if (firstPos == -1) {
                firstPos = mid;
                search(nums, mid + 1, nums.length - 1, target);
                search(nums, 0, mid - 1, target);
            }
            else {
                if (mid < firstPos)
                    search(nums, 0, mid - 1, target);
                else
                    search(nums, mid + 1, nums.length - 1, target);
            }
        }
        else if (target < nums[mid]) {
            if (low == high)
                return;
            search(nums, low, mid - 1, target);
        }
        else {
            if (low == high)
                return;
            search(nums, mid + 1, high, target);
        }
    }
}
