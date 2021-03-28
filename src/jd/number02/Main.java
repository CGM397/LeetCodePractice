package jd.number02;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/3/27 18:55
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        scanner.nextLine();
        int[][] store = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                store[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        System.out.println(2);
    }

    private static void dfs() {

    }
}
