package Q1TO50.number45;

/**
 * @author: Bright Chan
 * @date: 2020/8/22 15:05
 * @description: 贪心算法
 */
public class Solution {

    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    //超时了
    private int res = 0, steps = 0;
    public int myJump(int[] nums) {
        res = nums.length - 1;
        backTracking(0, nums);
        return res;
    }

    private void backTracking(int pos, int[] nums) {
        if (pos + nums[pos] < nums.length - 1 && steps + 2 >= res) return;
        if (pos + nums[pos] >= nums.length - 1 && steps + 1 >= res) return;
        if (pos == nums.length - 1) {
            if (steps > res) res = steps;
            return;
        }
        for (int i = 1; i <= nums[pos] && pos + i < nums.length; i++) {
            steps += 1;
            backTracking(pos + i, nums);
            steps -= 1;
        }
    }
}
