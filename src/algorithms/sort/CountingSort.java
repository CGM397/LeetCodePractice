package algorithms.sort;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 13:06
 * @description: 计数排序，只能用于0到k的整数排序
 */
public class CountingSort {

    public int[] sort(int[] store) {
        int[] arr = Arrays.copyOf(store, store.length);

        int maxValue = arr[0];

        for (int one : arr) {
            if (one > maxValue) maxValue = one;
        }

        int[] buckets = new int[maxValue + 1];

        for (int one : arr) {
            buckets[one]++;
        }

        int arrIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            int one = buckets[i];
            while (one > 0) {
                arr[arrIndex++] = i;
                one--;
            }
        }
        return arr;
    }
}
