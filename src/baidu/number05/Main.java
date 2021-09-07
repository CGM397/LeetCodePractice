package baidu.number05;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/7 18:18
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            getRes(scanner.nextLine());
        }
    }

    private static void getRes(String num) {
        char[] res = new char[num.length()];
        char[] store = num.toCharArray();
        for (int i = num.length() - 1; i >= 0; i--) {
            char one = store[i];
            if (one > '3') {
                for (int j = i; j < num.length(); j++) {
                    res[j] = '3';
                }
            }
            else if (one == '1' || one == '2' || one == '3') {
                res[i] = one;
            }
            else if (one == '0') {
                int index = i - 1;
                while (index >= 0 && store[index] == '0') {
                    index--;
                }
                if (index < 0) {
                    res[0] = '0';
                    break;
                }
                store[index]--;
                for (int j = index + 1; j < num.length(); j++) {
                    res[j] = '3';
                }
                i = index + 1;
            }
        }

        int index = 0;
        while (index < num.length() && res[index] == '0') {
            index++;
        }
        for (int i = index; i < num.length(); i++) {
            System.out.print(res[i]);
        }
        System.out.println();
    }
}
