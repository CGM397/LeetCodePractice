package algorithms.sort.insertion;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 12:59
 * @description: 插入排序
 */
public class InsertionSort {

    public void sort(int[] store) {
        if (store == null || store.length <= 1) return;

        int len = store.length, preIndex, current;

        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = store[i];

            while (preIndex >= 0 && store[preIndex] > current) {
                // 交换
                store[preIndex + 1] = store[preIndex];
                preIndex--;
            }
            store[preIndex + 1] = current;
        }
    }
}
