import someAlgorithms.sort.RadixSort;



/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        RadixSort sort = new RadixSort();
        int[] store = new int[]{2,4,7,5,8,1,3,6};
        store = sort.sort(store);
        for (int i : store) System.out.println(i);
    }
}
