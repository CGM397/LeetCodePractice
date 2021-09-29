package wangyi.number01;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/18 19:24
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt();
        System.out.println(getRealSix(a, b));
    }

    private static int getRealSix(int a, int b) {
        int res = 0;

        for (int i = a; i <= b; i++) {
            String cast = String.valueOf(i);
            if (cast.indexOf('6') != -1 || cast.contains("17")) {
                res++;
            }
        }

        return res;
    }
}
