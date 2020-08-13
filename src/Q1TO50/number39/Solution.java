package Q1TO50.number39;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/13 16:36
 * @description: 回溯算法，需要注意java中的引用以及深拷贝、浅拷贝的问题
 */
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> one = new ArrayList<>();

    private int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //sort
        int tmp;
        for (int i = 0; i < candidates.length - 1; i++) {
            for (int j = i + 1; j < candidates.length; j++) {
                if (candidates[i] > candidates[j]) {
                    tmp = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = tmp;
                }
            }
        }

        backTracking(0, candidates, target);
        return res;
    }

    private void backTracking(int nextPos, int[] candidates, int target) {
        if (sum == target) {
            List<Integer> tmp = new ArrayList<>(one);
            res.add(tmp);
        }
        else if (sum < target) {
            for (int i = nextPos; i < candidates.length; i++) {
                if (sum + candidates[i] > target) return;
                sum += candidates[i];
                one.add(candidates[i]);
                backTracking(i, candidates, target);
                sum -= candidates[i];
                one.remove((Object) candidates[i]);
            }
        }
    }
}
