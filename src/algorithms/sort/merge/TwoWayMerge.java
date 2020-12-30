package algorithms.sort.merge;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 13:05
 * @description: 二路归并排序
 */
public class TwoWayMerge {

    public int[] sort(int[] store) {
        if (store == null || store.length <= 1) return store;

        int mid = store.length / 2;
        int[] left = Arrays.copyOfRange(store, 0, mid);
        int[] right = Arrays.copyOfRange(store, mid, store.length);

        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int leftLen = left.length, rightLen = right.length;
        int[] res = new int[leftLen + rightLen];

        int i = 0, j = 0, count = 0;

        while (i < leftLen && j < rightLen) {
            if (left[i] < right[j]) {
                res[count] = left[i];
                i++;
            }
            else {
                res[count] = right[j];
                j++;
            }
            count++;
        }

        while (i < leftLen) {
            res[count] = left[i];
            i++;
            count++;
        }
        while (j < rightLen) {
            res[count] = right[j];
            j++;
            count++;
        }

        return res;
    }
}
