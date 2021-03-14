package meituan.number01;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/3/13 15:55
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        int[][] store = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                store[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        getRes(store, n, m);
    }

    private static void getRes(int[][] store, int n, int m) {
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = store[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            boolean first = true;
            for (int j = 0; j < n; j++) {
                if (first) {
                    System.out.print(res[i][j]);
                    first = false;
                }
                else {
                    System.out.print(" " + res[i][j]);
                }
            }
            System.out.println();
        }
    }
}
