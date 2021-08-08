package pdd.number01;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/8/8 19:02
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                System.out.println();
            }
            int x = scanner.nextInt(), y = scanner.nextInt(), r = scanner.nextInt();
            scanner.nextLine();

            int x1 = Math.abs(x), y1 = Math.abs(y);
            if (x * x + y * y == r * r) {
                if (x == 0 || y == 0) {
                    System.out.print(2);
                }
                else {
                    System.out.print(3);
                }
            }
            else if (x1 > r) {
                if (y1 > r) {
                    System.out.print(0);
                }
                else if (y1 == r) {
                    System.out.print(1);
                }
                else {
                    System.out.print(2);
                }
            }
            else if (x1 == r) {
                if (y1 > r) {
                    System.out.print(1);
                }
                else if (y1 == r) {
                    System.out.print(2);
                }
                else {
                    System.out.print(3);
                }
            }
            else {
                if (y1 > r) {
                    System.out.print(2);
                }
                else if (y1 == r) {
                    System.out.print(3);
                }
                else {
                    System.out.print(4);
                }
            }
        }
    }
}
