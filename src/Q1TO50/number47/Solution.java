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
        backTracking(0, nums);
        return res;
    }

    private void backTracking(int pos, int[] nums) {
        if (pos == nums.length) {
            if (res.contains(one)) return;
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
