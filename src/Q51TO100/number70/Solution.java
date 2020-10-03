package Q51TO100.number70;

/**
 * @author: Bright Chan
 * @date: 2020/10/3 15:28
 * @description: 动态规划；一元动态规划典型题
 */
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] store = new int[n];
        store[0] = 1;
        store[1] = 2;
        for (int i = 2; i < n; i++) {
            store[i] = store[i - 1] + store[i - 2];
        }
        return store[n - 1];
    }
}
