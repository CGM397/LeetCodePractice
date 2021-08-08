package pdd.number03;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/8/8 19:50
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String ops = scanner.nextLine();

        String str = "";
        // 光标在下标为index的字符后面
        int index = -1;
        int preRes = 0;
        boolean first = true;

        for (char one : ops.toCharArray()) {
            switch (one) {
                case '(':
                    index++;
                    str = str.substring(0, index) + "(" + str.substring(index);
                    break;
                case ')':
                    index++;
                    str = str.substring(0, index) + ")" + str.substring(index);
                    break;
                case 'L':
                    if (index >= 0) {
                        index--;
                    }
                    break;
                case 'R':
                    if (index < str.length() - 1) {
                        index++;
                    }
                    break;
                case 'D':
                    if (index == 0) {
                        str = str.substring(1);
                        index = -1;
                    } else if (index > 0) {
                        str = str.substring(0, index) + str.substring(index + 1);
                        index--;
                    }
                    break;
            }

            int res;
            if (one == 'L' || one == 'R') {
                res = preRes;
            }
            else {
                res = getRes(str);
                preRes = res;
            }
            if (first) {
                first = false;
            }
            else {
                System.out.print(" ");
            }
            System.out.print(res);
        }
        System.out.println();
    }

    private static int getRes(String str) {
        int store = 0, max = 0, ops = 0;
        boolean valid = true;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                store++;
                if (store > max) {
                    max = store;
                }
            }
            else if (c == ')') {
                if (store == 0) {
                    valid = false;
                    ops++;
                }
                else {
                    store--;
                }
            }
        }
        return store == 0 && valid ? max : -ops - store;
    }
}
