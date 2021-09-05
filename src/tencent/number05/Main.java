package tencent.number05;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/5 21:24
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] tmp = scanner.nextLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tmp[i]);
        }

        int res = n - 1;
        for (int len = 3; len <= n; len++) {

            for (int l = 0; l <= n - len; l++) {
                int r = l + len - 1;
                int min1 = a[l], min2 = a[r];
                boolean flag = true;
                for (int i = l + 1; i < r; i++) {
                    if (a[i] < min1 || a[i] < min2) {
                        flag = false;
                        if (a[i] < min1) l = i - 1;
                        break;
                    }
                }
                if (flag) res++;
            }
        }

        System.out.println(res);
    }
}
