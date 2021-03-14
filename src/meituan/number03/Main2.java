package meituan.number03;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author: Bright Chan
 * @date: 2021/3/13 16:45
 * @description: TODO
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        scanner.nextLine();
        int[] store = new int[n];
        String[] tmp = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            store[i] = Integer.parseInt(tmp[i]);
        }

        getRes(store, n, k);
    }

    private static void getRes(int[] store, int n, int k) {
        int left = 0, right = k - 1;
        TreeMap<Integer, Integer> res = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            res.put(store[i], res.getOrDefault(store[i], 0) + 1);
        }
        while (right < n) {
            int max = 0, maxNum = 0;
            for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    maxNum = entry.getKey();
                }
            }
            System.out.println(maxNum);
            if (right + 1 == n) return;

            res.put(store[left], res.get(store[left]) - 1);
            if (res.get(store[left]) == 0) {
                res.remove(store[left]);
            }
            left++;
            right++;
            res.put(store[right], res.getOrDefault(store[right], 0) + 1);
        }
    }
}
