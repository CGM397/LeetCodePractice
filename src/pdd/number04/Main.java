package pdd.number04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/8/8 20:43
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();

        String[] tmp = scanner.nextLine().split(" ");
        int[] store = new int[n];
        for (int i = 0; i < n; i++) {
            store[i] = Integer.parseInt(tmp[i]);
        }

        Arrays.sort(store);
    }
}
