import someAlgorithms.sort.insertion.ShellSort;



/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int[] store = new int[]{1,1,1,2,1,1};
        sort.sort(store);
        for (int i : store) System.out.println(i);
    }
}
