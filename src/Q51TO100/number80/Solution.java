package Q51TO100.number80;

/**
 * @author: Bright Chan
 * @date: 2020/10/13 21:55
 * @description: 数组
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        int res = nums.length, pre = nums[0], count = 1, flag = nums[0] - 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                count++;
                if (count > 2) {
                    nums[i] = flag;
                    res--;
                }
            }
            else {
                pre = nums[i];
                count = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == flag) {
                int j = i + 1;
                while (j < nums.length && nums[j] == flag) j++;
                if (j < nums.length) {
                    nums[i] = nums[j];
                    nums[j] = flag;
                }
            }
        }

        return res;
    }
}
