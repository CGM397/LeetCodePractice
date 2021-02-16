package Q551TO600.number561;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/2/16 10:00
 * @description: 数组
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
