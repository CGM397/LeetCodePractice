import microsoft.number02.Solution;



/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[] {2,3,3,5,8};
        int X = 2, Y = 5;
        System.out.println(solution.solution(A, X, Y));
    }
}
