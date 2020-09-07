import Q51TO100.number56.Solution;
import someAlgorithms.sort.exchange.BubbleSort;
import someAlgorithms.sort.exchange.QuickSort;


/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        QuickSort quickSort = new QuickSort();
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
