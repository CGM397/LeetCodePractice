package Q751TO800.number771;

/**
 * @author: Bright Chan
 * @date: 2020/10/2 11:25
 * @description: 字符串
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        for (int i = 0; i < J.length(); i++) {
            char target = J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == target) res++;
            }
        }
        return res;
    }
}
