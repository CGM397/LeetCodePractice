package Q1101TO1150.number1122;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: Bright Chan
 * @date: 2020/11/14 10:45
 * @description: 排序
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int i : arr2) store.put(i, 0);

        PriorityQueue<Integer> others = new PriorityQueue<>();
        for (int i : arr1) {
            if (store.containsKey(i)) store.put(i, store.get(i) + 1);
            else others.add(i);
        }

        int[] res = new int[arr1.length];
        int i = 0;
        for (int j : arr2) {
            for (int k = 0; k < store.get(j); k++) {
                res[i] = j;
                i++;
            }
        }
        while (!others.isEmpty()) {
            res[i] = others.poll();
            i++;
        }
        return res;
    }
}
