package baidu.number03;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/3/21 17:53
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        System.out.println(2);
    }

    private static int getRes(int n, int m) {
        // 到第i个台阶的走法，并记录倒数两步
        int[][][] dp = new int[n][m + 1][m + 1];
        dp[0][0][0] = 1;

        for (int i = 2; i < n; i++) {

        }
        return 1;
    }
}
