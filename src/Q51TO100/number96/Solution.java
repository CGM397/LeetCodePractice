package Q51TO100.number96;

/**
 * @author: Bright Chan
 * @date: 2021/3/20 15:43
 * @description: 动态规划
 */
public class Solution {
    public int numTrees(int n) {
        if (n <= 2) return n;

        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = numTrees(i);
            left = left == 0 ? 1 : left;
            int right = numTrees(n - i - 1);
            right = right == 0 ? 1 : right;
            res += left * right;
        }
        return res;
    }
}
