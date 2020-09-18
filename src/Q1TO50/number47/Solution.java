package Q1TO50.number47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/22 16:11
 * @description: 全排列 + 去重，可以排序加剪枝
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> one = new ArrayList<>();
    private boolean[] flag;

    public List<List<Integer>> permuteUnique(int[] nums) {
        flag = new boolean[nums.length];
        Arrays.fill(flag, false);
        Arrays.sort(nums);
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
            if (flag[i] || (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])) {
                continue;
            }
            flag[i] = true;
            one.add(nums[i]);
            backTracking(pos + 1, nums);
            flag[i] = false;
            one.remove(pos);
        }
    }
}
