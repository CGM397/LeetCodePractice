package meituan.number08;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/8/22 10:43
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(getRes(0, str.length() - 1, str.toCharArray()));
    }

    private static long MOD = 1000000007;

    private static long getRes(int start, int end, char[] store) {
        if (start >= end) {
            return 1;
        }

        long res = 1, tmp = 0;
        for (int i = start; i <= end; i++) {
            if (store[i] == '(') {
                tmp++;
                if (tmp > 0) {
                    int index = i + 1;
                    while (index <= end) {
                        if (store[index] == '(') tmp++;
                        if (store[index] == ')') tmp--;
                        if (tmp == 0) break;
                        index++;
                    }

                    res = (res * (getRes(i + 1, index - 1, store) + 1)) % MOD;
                    i = index;
                }
            }
        }
        return res;
    }
}
