package Q1TO50.number34;

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
        //确保左右边界在第一次更新时都能更新
        left = nums.length;
        search(nums, 0, nums.length - 1, target);

        if (left != nums.length && right != -1) {
            res[0] = left;
            res[1] = right;
        }
        return res;
    }

    //逻辑有一点点混乱，但是耗时很小 :)
    private void search(int[] nums, int low, int high, int target) {
        if (low > high) return;

        int mid = low + (high - low) / 2;
        if (target == nums[mid]) {
            //更新左右边界
            if (mid > right)
                right = mid;
            if (mid < left)
                left = mid;

            //如果是第一次找到target，则向两边继续寻找
            if (firstPos == -1) {
                firstPos = mid;
                search(nums, mid + 1, nums.length - 1, target);
                search(nums, 0, mid - 1, target);
            }
            // 如果不是第一次找到，则看找到的位置在第一个的哪边，
            // 在左边就继续向左寻找，在右边就继续向右寻找
            else {
                if (mid < firstPos)
                    search(nums, 0, mid - 1, target);
                else
                    search(nums, mid + 1, nums.length - 1, target);
            }
        }
        else if (target < nums[mid]) {
            search(nums, low, mid - 1, target);
        }
        else {
            search(nums, mid + 1, high, target);
        }
    }
}
