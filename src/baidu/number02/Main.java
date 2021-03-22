package baidu.number02;

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

        String[] store = scanner.nextLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(store[i]);
        }

        for (int i = 0; i < m; i++) {
            int flag = scanner.nextInt();
            int left = scanner.nextInt(), right = scanner.nextInt();
            scanner.nextLine();
            int res = getRes(num, n, left - 1, right - 1, flag);
            System.out.println(res);
        }
    }

    private static int getRes(int[] num, int n, int left, int right, int flag) {
        int MOD = 1000000007;
        int[] even = new int[n];
        int[] odd = new int[n];
        even[left] = num[left] % 2 == 0 ? 1 : 0;
        odd[left] = num[left] % 2 == 0 ? 0 : 1;

        for (int i = left + 1; i <= right; i++) {
            int cur = num[i];
            if (cur % 2 == 0) {
                even[i] = (even[i - 1] * 2 + odd[i - 1] + 1) % MOD;
                odd[i] = odd[i - 1];
            }
            else {
                even[i] = (even[i - 1] * 2) % MOD;
                odd[i] = (odd[i - 1] * 2 + 1) % MOD;
            }
        }
        if (flag == 1) return odd[right] % MOD;
        else return even[right] % MOD;
    }
}
