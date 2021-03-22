package baidu.number01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/3/21 17:52
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        int[] store = new int[n];
        for (int i = 0; i < n; i++) {
            store[i] = Integer.parseInt(line.charAt(i) + "");
        }
        getRes(store, n);
    }

    private static void getRes(int[] store, int n) {
        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n <= 2) {
            System.out.println(n - 1);
            return;
        }
        long[] dp = new long[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        HashMap<Integer, Long> count = new HashMap<>();
        count.put(store[0], 0L);
        count.put(store[1], 1L);

        for (int i = 2; i < n; i++) {
            int cur = store[i];
            boolean find = count.containsKey(cur);

            if (!find) {
                dp[i] = dp[i - 1] + 1;
                count.put(cur, dp[i]);
            }
            else {
                long min = count.get(cur);
                dp[i] = Math.min(dp[i - 1] + 1, min + 1);
                if (dp[i] < min) {
                    count.put(cur, dp[i]);
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
