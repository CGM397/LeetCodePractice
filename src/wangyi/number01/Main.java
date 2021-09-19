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
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            scanner.nextLine();
            System.out.println(getRealSix(a, b));
        }
    }

    private static int getRealSix(int a, int b) {
        String searchChar = "6";
        int res = 0;

        for (int i = a; i <= b; i++) {
            String cast = String.valueOf(i);
            if (cast.indexOf('6') != -1 && cast.indexOf('8') != -1) {
                int originLen = cast.length();

                cast = cast.replace(searchChar, "");
                int newLen = cast.length();

                res += originLen - newLen;
            }
        }

        return res;
    }
}
