package Q601TO650.number645;

/**
 * @author: Bright Chan
 * @date: 2021/7/4 13:26
 * @description: 数学
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;

        int[] res = new int[2];
        for (int one : nums) {
            nums[(one - 1) % len] += len;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > len * 2) res[0] = i + 1;
            if (nums[i] <= len) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}
