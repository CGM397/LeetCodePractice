package Q601TO650.number628;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/1/20 13:17
 * @description: 数组
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        int count = 0;
        while (count < len && nums[count] < 0) count++;

        int res;
        if (count <= len - 3) {
            int tmp = nums[len - 1] * nums[len - 2] * nums[len - 3];
            res = nums[0] * nums[1] * nums[len - 1];
            res = Math.max(res, tmp);
        }
        else if (count == len - 2) {
            if (count >= 2) {
                res = nums[0] * nums[1] * nums[len - 1];
            }
            else {
                res = nums[0] * nums[1] * nums[2];
            }
        }
        else if (count == len - 1) {
            res = nums[0] * nums[1] * nums[len - 1];
        }
        else {
            res = nums[len - 1] * nums[len - 2] * nums[len - 3];
        }

        return res;
    }
}
