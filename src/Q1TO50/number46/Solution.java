package Q1TO50.number46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/22 15:58
 * @description: 全排列
 */
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> one = new ArrayList<>();
    private boolean[] flag;

    public List<List<Integer>> permute(int[] nums) {
        flag = new boolean[nums.length];
        Arrays.fill(flag, false);
        backTracking(0, nums);
        return res;
    }

    private void backTracking(int pos, int[] nums) {
        if (pos == nums.length) {
            List<Integer> oneRes = new ArrayList<>(one);
            res.add(oneRes);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                one.add(pos, nums[i]);
                backTracking(pos + 1, nums);
                flag[i] = false;
                one.remove(pos);
            }
        }
    }
}
