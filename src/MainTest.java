import Q51TO100.number93.Solution;

import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: TODO
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.restoreIpAddresses("25525511135");
        for (String one : res)
            System.out.println(one);
    }
}
