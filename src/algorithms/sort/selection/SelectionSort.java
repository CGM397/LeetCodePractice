package algorithms.sort.selection;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 13:03
 * @description: 选择排序
 */
public class SelectionSort {

    public void sort(int[] store) {
        if (store == null || store.length <= 1) return;

        int len = store.length;

        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (store[j] < store[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = store[i];
                store[i] = store[minIndex];
                store[minIndex] = temp;
            }
        }
    }
}
