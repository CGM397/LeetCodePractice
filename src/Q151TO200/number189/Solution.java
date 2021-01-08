package Q151TO200.number189;

/**
 * @author: Bright Chan
 * @date: 2021/1/8 9:20
 * @description: 数组
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1) return;
        int len = nums.length;
        k = k % len;

        int tmp;
        while (k > 0) {
            for (int i = len - 1; i >= 1; i--) {
                tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            }
            k--;
        }
    }
}
