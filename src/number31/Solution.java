package number31;

/**
 * @author: Bright Chan
 * @date: 2020/8/3 12:37
 * @description: 查找下一个字典序
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int swap;
        boolean flag = false;
        //数组从右往左查找第一个小于右边数字的数字，将其与其右边大于它的最小数字交换，
        //将右边数字升序排列
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                flag = true;
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = swap;
                        break;
                    }
                }
                for (int k = i; k < (nums.length - i) / 2 + i; k++) {
                    swap = nums[k];
                    nums[k] = nums[nums.length + i - 1 - k];
                    nums[nums.length + i - 1 - k] = swap;
                }
                break;
            }
        }
        if (!flag) {
            for (int i = 0; i < nums.length / 2; i++) {
                swap = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = swap;
            }
        }
    }
}
