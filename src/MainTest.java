import Q201TO250.number214.Solution;
import someAlgorithms.stringMatch.KMP;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.shortestPalindrome("acd"));
        KMP kmp = new KMP();
        int[] next = kmp.getNext("1111");
        for (int i : next) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(kmp.kmp("123121", "21"));
    }
}
