package meituan.number03;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/3/13 16:25
 * @description: TODO
 */
public class Main {
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
        int max = 0, maxNum = 0;
        for (int i = 0; i < k; i++) {
            res.put(store[i], res.getOrDefault(store[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxNum = entry.getKey();
            }
        }
        while (right < n) {
            System.out.println(maxNum);
            if (right + 1 == n) return;

            int tmp = max;
            res.put(store[left], res.get(store[left]) - 1);
            if (res.get(store[left]) == 0) {
                res.remove(store[left]);
            }
            if (store[left] == maxNum) {
                max--;
            }
            left++;

            right++;
            res.put(store[right], res.getOrDefault(store[right], 0) + 1);
            if (store[right] == maxNum) {
                max++;
                continue;
            }

            if (max < tmp) {
                for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        maxNum = entry.getKey();
                    }
                }
            }
        }
    }
}
