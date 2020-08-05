import Q1TO50.number35.Solution;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: TODO
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        int res = solution.searchInsert(nums, target);
        System.out.println(res);
    }
}
