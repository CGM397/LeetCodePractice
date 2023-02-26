package Q251TO300.number287;

/**
 * @author: Solution
 * @date: 2023/2/26 21:46
 * @description: findDuplicate
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] % len - 1;
            nums[index] += len;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 * len) {
                return i + 1;
            }
        }
        return 0;
    }
}
