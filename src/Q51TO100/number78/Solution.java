package Q51TO100.number78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/9/20 9:46
 * @description: 回溯算法
 */
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private Stack<Integer> oneRes = new Stack<>();
    private boolean[] flags;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1) return res;
        flags = new boolean[nums.length];
        Arrays.fill(flags, false);

        for (int i = 0; i <= nums.length; i++) {
            dfs(0, 0, nums, i);
        }
        return res;
    }

    private void dfs(int count, int pos, int[] nums, int num) {
        if (count == num) {
            res.add(new ArrayList<>(oneRes));
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            if (!flags[i]) {
                oneRes.push(nums[i]);
                flags[i] = true;
                dfs(count + 1, i + 1, nums, num);
                flags[i] = false;
                oneRes.pop();
            }
        }
    }
}
