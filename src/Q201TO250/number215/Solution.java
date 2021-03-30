package Q201TO250.number215;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/3/29 13:52
 * @description: 排序
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
