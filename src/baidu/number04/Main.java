package baidu.number04;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/7 18:18
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        scanner.nextLine();

        int[][] store = new int[n * k][n * k];
        int row = 0;
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(line[j]);
                for (int r = 0; r < k; r++) {
                    for (int m = 0; m < k; m++) {
                        store[row + r][j * k + m] = tmp;
                    }
                }
            }
            row += k;
        }

        for (int i = 0; i < n * k; i++) {
            for (int j = 0; j < n * k; j++) {
                System.out.print(store[i][j] + " ");
            }
            System.out.println();
        }
    }
}
