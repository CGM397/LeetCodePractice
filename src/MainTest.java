import algorithms.search.BinarySearch;



/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] store = new int[]{1,3,5,7,9,11};
        System.out.println(search.search(store, 11));
    }
}
