package tencent.number07;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/26 19:55
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t >= 1) {
            System.out.println(judge(scanner.nextInt(), scanner.nextInt()));
            t--;
        }
    }

    private static int judge(int n, int d) {
        return 1;
    }
}
