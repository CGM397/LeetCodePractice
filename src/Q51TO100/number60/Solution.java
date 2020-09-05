package Q51TO100.number60;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/9/5 9:46
 * @description: 回溯算法
 */
public class Solution {

    private boolean[] flags;
    private int count = 0;
    private Stack<Integer> one = new Stack<>();
    private StringBuilder res = new StringBuilder();
    private boolean find = false;
    public String getPermutation(int n, int k) {
        flags = new boolean[n];
        Arrays.fill(flags, false);
        backTracking(0, n, k);
        return res.toString();
    }

    private void backTracking(int pos, int n, int k) {
        if (pos == n) {
            count++;
            if (count == k) {
                for (Integer i : one) {
                    res.append(i);
                }
                find = true;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!flags[i]) {
                one.push(i + 1);
                flags[i] = true;
                backTracking(pos + 1, n, k);
                if (find) return;
                flags[i] = false;
                one.pop();
            }
        }
    }
}
