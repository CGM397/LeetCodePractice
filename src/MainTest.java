import shopee.number02.Solution;



/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rooms = new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[] statPoint = new int[] {0, 0};
        int[] endPoint = new int[] {2, 2};
        System.out.println(solution.minimumInitHealth(rooms, statPoint, endPoint));
    }
}
