package tencent.number02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/5 20:15
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] storeA = scanner.nextLine().split(" ");
        int[] a = getRes(storeA, n);
        Arrays.sort(a);
        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listA.add(a[i]);
        }

        String[] storeB = scanner.nextLine().split(" ");
        int[] b = getRes(storeB, n);

        int res = 0;
        for (int cur : b) {
            int index = listA.size() - 1;
            while (index >= 0 && listA.get(index) > cur) {
                index--;
            }
            // a中最大的比cur小或相等, 田忌赛马
            if (index == listA.size() - 1) {
                listA.remove(0);
            }
            else {
                listA.remove(index + 1);
                res++;
            }
        }
        System.out.println(res);
    }

    private static int[] getRes(String[] store, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(store[i]);

            int count = 0, sqrt = (int) Math.sqrt(tmp);
            for (int j = 1; j < Math.sqrt(tmp); j++) {
                if (tmp % j == 0) {
                    count += 2;
                }
            }
            if (sqrt * sqrt == tmp) {
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}
