import Q1TO50.number39.Solution;

import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        solution.combinationSum(candidates, target);
    }
}
