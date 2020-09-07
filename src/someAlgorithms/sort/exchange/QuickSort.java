package someAlgorithms.sort.exchange;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 12:58
 * @description: 快速排序
 */
public class QuickSort {

    public void sort(int[] store) {
        if (store == null || store.length <= 1) return;

        recurse(store, 0, store.length - 1);
    }

    private void recurse(int[] store, int low, int high) {
        if (low >= high) return;

        int i = low, j = high, base = store[low], tmp;

        // 完成一趟排序
        while (i < j) {
            // 从右往左找 比基准数小的数
            while (i < j && store[j] > base) {
                j--;
            }
            // 从左往右找 比基准数大的数
            while (i < j && store[i] <= base) {
                i++;
            }
            // j在i右边时，需要交换
            if (i < j) {
                tmp = store[i];
                store[i] = store[j];
                store[j] = tmp;
            }
        }
        // 交换base和i、j重合点
        store[low] = store[i];
        store[i] = base;

        // 对base左右数组进行排序
        recurse(store, low, i - 1);
        recurse(store, i + 1, high);
    }
}
