package Q51TO100.number55;

/**
 * @author: Bright Chan
 * @date: 2020/8/29 16:50
 * @description: 数组
 */
public class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        boolean flag;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i < nums.length - 1) {
                flag = false;
                for (int j = 0; j < i; j++) {
                    if (nums[j] > i - j) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;
            }
        }
        return true;
    }
}
