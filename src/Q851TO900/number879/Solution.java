package Q851TO900.number879;

/**
 * @author: Bright Chan
 * @date: 2021/3/9 14:01
 * @description: TODO
 */
public class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int N = group.length;
        // 其实只是二维数组，第一维为0表示之前的结果，1表示更新之后的结果
        // 第二维表示最低利润，第三维表示需要的工人数
        // 数组的含义：使用g个工人能创造的利润大于等于p的方案数
        long[][][] dp = new long[2][P + 1][G + 1];
        // ？
        dp[0][0][0] = 1;

        for (int i = 0; i < N; ++i) {
            // 当前任务的利润
            int p0 = profit[i];
            // 当前任务所需的工人数
            int g0 = group[i];

            long[][] cur = dp[i % 2];
            long[][] cur2 = dp[(i + 1) % 2];

            // Deep copy cur into cur2
            for (int jp = 0; jp <= P; ++jp) {
                for (int jg = 0; jg <= G; ++jg) {
                    cur2[jp][jg] = cur[jp][jg];
                }
            }

            for (int p1 = 0; p1 <= P; ++p1) {  // p1 : the current profit
                // p2 : the new profit after committing this crime
                // p1 + p0 大于P的时候，就写P，因为题目就要求到P，就不需要考虑大于P的利润了。
                int p2 = Math.min(p1 + p0, P);
                for (int g1 = 0; g1 <= G - g0; ++g1) {  // g1 : the current group size
                    // g2 : the new group size after committing this crime
                    int g2 = g1 + g0;
                    cur2[p2][g2] += cur[p1][g1];
                    cur2[p2][g2] %= MOD;
                }
            }
        }

        // Sum all schemes with profit P and group size 0 <= g <= G.
        long ans = 0;
        for (long x : dp[N % 2][P]) {
            ans += x;
        }

        return (int) (ans% MOD);
    }
}
