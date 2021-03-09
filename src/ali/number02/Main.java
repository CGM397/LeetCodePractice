package ali.number02;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/3/8 19:00
 * @description: 动态规划
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            int m = scanner.nextInt(), n = scanner.nextInt(), p = scanner.nextInt();
            scanner.nextLine();
            String[] storeA = scanner.nextLine().split(" ");
            String[] storeB = scanner.nextLine().split(" ");
            int[] a = new int[m];
            int[] b = new int[m];
            for (int j = 0; j < m; j++) {
                a[j] = Integer.parseInt(storeA[j]);
                b[j] = Integer.parseInt(storeB[j]);
            }
            getMaxProfit(n, p, a, b);
        }
    }

    private static void getMaxProfit(int n, int p, int[] a, int[] b) {
        int MOD = 1000000007;
        int taskNum = a.length;
        long[][][] dp = new long[2][p + 1][n + 1];
        dp[0][0][0] = 1;

        for (int i = 0; i < taskNum; i++) {
            long[][] cur = dp[i % 2];
            long[][] cur2 = dp[(i + 1) % 2];

            for (int j = 0; j <= p; j++) {
                if (n + 1 >= 0) System.arraycopy(cur[j], 0, cur2[j], 0, n + 1);
            }

            for (int j = 0; j <= p; j++) {
                int p1 = Math.min(j + b[i], p);
                for (int k = 0; k <= n - a[i]; k++) {
                    int g = k + a[i];
                    cur2[p1][g] += cur[j][k];
                    cur2[p1][g] %= MOD;
                }
            }
        }

        long res = 0;
        for (long x : dp[taskNum % 2][p]) {
            res += x;
        }
        int realRes = (int) (res % MOD);
        System.out.println(realRes);
    }
}
