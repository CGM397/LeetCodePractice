import Q1TO50.number42.Solution;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(candidates));
    }
}
