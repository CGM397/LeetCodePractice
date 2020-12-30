package algorithms.search;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/8/4 13:14
 * @description: 二分查找
 */
public class BinarySearch {

    public int search(int[] store, int target) {
        if (store == null || store.length < 1) return -1;

        Arrays.sort(store);
        int start = 0, end = store.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;

            if (store[mid] == target) return mid;
            else if (store[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }
}
