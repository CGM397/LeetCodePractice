package algorithms.sort.selection;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/8/2 13:03
 * @description: 堆排序
 */
public class HeapSort {

    public int[] sort(int[] store) {
        if (store == null || store.length <= 1) return store;

        int[] arr = Arrays.copyOf(store, store.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    // 调整堆
    private void heapify(int[] arr, int i, int len) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        if (leftChild < len && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < len && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // 需要调整
        // 调整完还需要再次检查此堆
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
