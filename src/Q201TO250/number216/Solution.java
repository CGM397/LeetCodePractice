package Q201TO250.number216;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/9/11 13:03
 * @description: 回溯算法
 */
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private Stack<Integer> oneResStore = new Stack<>();
    private int oneRes = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, 1, k, n);
        return res;
    }

    private void dfs(int count, int next, int k, int n) {
        if (count == k) {
            if (oneRes == n) res.add(new ArrayList<>(oneResStore));
            return;
        }

        if (count + 9 - next + 1 < k) return;

        for (int i = next; i <= 9; i++) {
            if (oneRes + i > n) return;
            oneRes += i;
            oneResStore.push(i);
            dfs(count + 1, i + 1, k, n);
            oneRes -= i;
            oneResStore.pop();
        }
    }
}
