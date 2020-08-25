package Q451TO500.number491;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2020/8/25 16:35
 * @description: 深度优先搜索
 */
public class Solution {

    private Set<List<Integer>> store = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(0, nums, new ArrayList<>());
        return new ArrayList<>(store);
    }

    private void backTracking(int pos, int[] nums, List<Integer> tmp) {
        if (pos >= nums.length) return;

        for (int i = pos; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    if (tmp.size() == 0) {
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        store.add(new ArrayList<>(tmp));
                        backTracking(j, nums, tmp);
                        tmp.remove((Object) nums[j]);
                        tmp.remove((Object) nums[i]);
                    }
                    else if (nums[i] >= tmp.get(tmp.size() - 1)) {
                        tmp.add(nums[j]);
                        store.add(new ArrayList<>(tmp));
                        backTracking(j, nums, tmp);
                        tmp.remove((Object) nums[j]);
                    }
                }
            }
        }
    }
}
