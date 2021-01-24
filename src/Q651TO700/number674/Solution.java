package Q651TO700.number674;

/**
 * @author: Bright Chan
 * @date: 2021/1/24 10:35
 * @description: 数组
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = -1, count = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= pre) {
                if (count > res) res = count;
                count = 1;
            }
            else {
                count++;
            }
            pre = nums[i];
        }
        return Math.max(res, count);
    }
}
