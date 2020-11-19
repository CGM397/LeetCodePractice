package Q251TO300.number283;

/**
 * @author: Bright Chan
 * @date: 2020/11/19 19:02
 * @description: 双指针
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0, noZero = 0;

        while (zero < nums.length && noZero < nums.length) {
            while (zero < nums.length && nums[zero] != 0) zero++;
            noZero = zero;
            while (noZero < nums.length && nums[noZero] == 0) noZero++;

            if (zero >= nums.length || noZero >= nums.length) break;
            int tmp = nums[zero];
            nums[zero] = nums[noZero];
            nums[noZero] = tmp;

            zero++;
            noZero++;
        }
    }
}
