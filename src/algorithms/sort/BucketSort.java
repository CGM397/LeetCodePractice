package algorithms.sort;

import algorithms.sort.insertion.InsertionSort;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 13:06
 * @description: 桶排序
 */
public class BucketSort {

    // bucketSize: 每个桶的最大容量
    public int[] sort(int[] store, int bucketSize) {
        if (store == null || store.length <= 1) return store;

        int[] arr = Arrays.copyOf(store, store.length);

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int value : arr) {
            int index = (value - minValue) / bucketSize;
            buckets[index] = arrAppend(buckets[index], value);
        }

        int arrIndex = 0;
        InsertionSort insertionSort = new InsertionSort();
        for (int[] oneBucket : buckets) {
            if (oneBucket.length > 0) {
                // 对每个桶进行排序
                insertionSort.sort(oneBucket);

                for (int one : oneBucket) {
                    arr[arrIndex++] = one;
                }
            }
        }
        return arr;
    }

    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
