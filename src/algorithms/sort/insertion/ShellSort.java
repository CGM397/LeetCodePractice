package algorithms.sort.insertion;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 13:02
 * @description: 希尔排序
 */
public class ShellSort {

    public void sort(int[] store) {
        if (store == null || store.length <= 1) return;

        int len = store.length;

        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            // 分组做插入排序
            for (int i = gap; i < len; i++) {
                int j = i, current = store[i];

                while (j - gap >= 0 && current < store[j - gap]) {
                    store[j] = store[j - gap];
                    j -= gap;
                }
                store[j] = current;
            }
        }
    }
}
