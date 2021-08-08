package pdd.number02;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/8/8 19:29
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong(), t = scanner.nextLong(), c = scanner.nextLong();
        scanner.nextLine();

        String[] tmp = scanner.nextLine().split(" ");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (Long.parseLong(tmp[i]) > t) {
                s.append("/");
            }
            else {
                s.append(tmp[i]).append(",");
            }
        }
        String[] store = s.toString().split("/");

        int res = 0;
        for (String value : store) {
            String[] one = value.split(",");
            res += one.length >= c ? one.length - c + 1 : 0;
        }
        System.out.println(res);
    }
}
