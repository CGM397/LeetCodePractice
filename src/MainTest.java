import number34.Solution;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: TODO
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        int[] res = solution.searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
