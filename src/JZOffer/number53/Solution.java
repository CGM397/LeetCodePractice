package JZOffer.number53;

/**
 * @author: Bright Chan
 * @date: 2021/7/16 21:35
 * @description: 数组
 */
public class Solution {
    public int search(int[] nums, int target) {
        int res = 0;
        for (int num : nums) {
            if (target == num) {
                res++;
            } else if (target < num) {
                break;
            }
        }
        return res;
    }
}
