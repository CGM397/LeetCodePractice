package Q601TO650.number650;

/**
 * @author: Bright Chan
 * @date: 2021/9/19 21:24
 * @description: dp
 */
public class Solution {
    public int minSteps(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }
}
