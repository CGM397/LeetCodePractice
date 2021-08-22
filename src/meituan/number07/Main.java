package meituan.number07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/8/22 10:25
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> store = new ArrayList<>();
        for (char one : s.toCharArray()) {
            store.add(one + "");
        }
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");

            if (line[0].equals("1")) {
                store.add(line[1]);
            }
            else {
                int index = Integer.parseInt(line[1]) - 1;
                if (index >= store.size() || index < 0) {
                    System.out.println(-1);
                    continue;
                }
                int left = -1, right = -1;
                String target = store.get(index);
                for (int j = index - 1; j >= 0; j--) {
                    if (store.get(j).equals(target)) {
                        left = j;
                        break;
                    }
                }
                for (int k = index + 1; k < store.size(); k++) {
                    if (store.get(k).equals(target)) {
                        right = k;
                        break;
                    }
                }
                if (left == -1) {
                    if (right == -1) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(right - index);
                    }
                }
                else if (right == -1) {
                    System.out.println(index - left);
                }
                else {
                    System.out.println(Math.min(right - index, index - left));
                }
            }
        }
    }
}
