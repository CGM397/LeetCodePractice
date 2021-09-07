package Q1201TO1250.number1221;

/**
 * @author: Bright Chan
 * @date: 2021/9/7 18:16
 * @description: 贪心
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                ++d;
            } else {
                --d;
            }
            if (d == 0) {
                ++ans;
            }
        }
        return ans;
    }
}
