package algorithms.sort.exchange;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 12:58
 * @description: 冒泡排序
 */
public class BubbleSort {

    public void sort(int[] store) {
        if (store == null || store.length <= 1) return;

        int tmp;

        for (int i = 0; i < store.length - 1; i++) {
            for (int j = 0; j < store.length - 1 - i; j++) {
                if (store[j] > store[j + 1]) {
                    tmp = store[j];
                    store[j] = store[j + 1];
                    store[j + 1] = tmp;
                }
            }
        }
    }
}
