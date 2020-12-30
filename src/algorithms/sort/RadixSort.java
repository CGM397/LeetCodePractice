package algorithms.sort;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 13:06
 * @description: 基数排序
 */
public class RadixSort {

    public int[] sort(int[] store) {
        int[] arr = Arrays.copyOf(store, store.length);

        int maxValue = arr[0];

        for (int one : arr) {
            if (one > maxValue) maxValue = one;
        }

        int maxDigit = getNumLength(maxValue);
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int item : arr) {
                int bucket = ((item % mod) / dev) + mod;
                counter[bucket] = arrAppend(counter[bucket], item);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;

    }

    private int getNumLength(int num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (int temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
