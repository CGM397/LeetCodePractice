package JZOffer.number42;

/**
 * @author: Bright Chan
 * @date: 2021/7/17 21:46
 * @description: dp
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
