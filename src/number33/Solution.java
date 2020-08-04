package number33;

/**
 * @author: Bright Chan
 * @date: 2020/8/4 10:09
 * @description: 二分查找
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length < 1) return -1;

        int left = 0, right = nums.length - 1, middle, midValue, startValue = nums[0];
        if (startValue == target) return 0;

        while (left <= right) {
            //防止left+right溢出
            middle = left + (right - left) / 2;
            midValue = nums[middle];
            if (target == midValue)
                return middle;
            else if (target < midValue) {
                if (startValue < target)
                    right = middle - 1;
                else {
                    if (midValue >= startValue)
                        left = middle + 1;
                    else
                        right = middle - 1;
                }
            }
            else {
                if (startValue > target)
                    left = middle + 1;
                else {
                    if (midValue < startValue)
                        right = middle - 1;
                    else
                        left = middle + 1;
                }
            }
        }
        return -1;
    }
}
