import number30.Solution;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: TODO
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(solution.findSubstring(s, words));
    }
}
