import Q1TO50.number41.Solution;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates = new int[]{1,1,2,5,6,7,10};
        System.out.println(solution.firstMissingPositive(candidates));
    }
}
