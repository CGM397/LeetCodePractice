package Q51TO100.number77;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2020/9/8 15:42
 * @description: 组合
 */
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private Stack<Integer> oneRes = new Stack<>();

    public List<List<Integer>> combine(int n, int k) {

        dfs(0, 0, n, k);
        return res;
    }

    private void dfs(int pos, int next, int n, int k) {
        if (pos + n - next < k) return;
        if (pos == k) {
            res.add(new ArrayList<>(oneRes));
            return;
        }

        for (int i = next; i < n; i++) {
            oneRes.push(i + 1);
            dfs(pos + 1, i + 1, n, k);
            oneRes.pop();
        }
    }
}
