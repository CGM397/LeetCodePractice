package meituan.number09;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/8/22 11:14
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] store = scanner.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(store[i]);
        }

        int[] sums = new int[n + 1];
        sums[0] = 0;
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int j = 0; j < m; j++) {
            int opt = scanner.nextInt(), l = scanner.nextInt(), r = scanner.nextInt();
            scanner.nextLine();

            if (opt == 1) {
                System.out.println(sums[r] - sums[l - 1]);
            }
            else if (opt == 2) {
                int sum = sums[r] - sums[l - 1];
                long res = 0;
                for (int k = l - 1; k < r; k++) {
                    int tmp = sum - nums[k];
                    res += tmp * tmp;
                }
                System.out.println(res);
            }
            else if (opt == 3) {
                int max = Integer.MIN_VALUE;
                for (int k = l - 1; k < r; k++) {
                    max = Math.max(max, nums[k]);
                }
                System.out.println(max);
            }
        }
    }
}
