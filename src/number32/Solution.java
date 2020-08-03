package number32;

/**
 * @author: Bright Chan
 * @date: 2020/8/3 17:05
 * @description: TODO
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        //用来记录左右括号，左括号加一，右括号减一
        //大于等于0继续，小于0停止
        int count;
        int countLen;
        int len = s.length();
        //记录i的上一次位置
        int j;
        for (int n = (len / 2) * 2; n >= 2; n -= 2) {
            j = 0;
            count = 0;
            countLen = 0;
            for (int i = 0; i < len; i++) {
                if (count == 0 && countLen == n) {
                    return n;
                }
                // 搜索了n个字符之后count仍然大于0，
                // 则从这一次搜索的起始下标后一位开始搜索
                else if (count > 0 && countLen == n) {
                    count = 0;
                    countLen = 0;
                    i = j;
                    j++;
                    continue;
                }
                if (s.charAt(i) == '(') {
                    count++;
                    countLen++;
                }
                else if (s.charAt(i) == ')') {
                    count--;
                    if (count < 0) {
                        //重置
                        count = 0;
                        countLen = 0;
                        j = i + 1;
                    }
                    else countLen++;
                }
            }
            if (count == 0 && countLen == n) return n;
        }
        return 0;
    }

    private boolean isValidParentheses(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            else if (s.charAt(i) == ')') {
                count--;
                if (count < 0)
                    return false;
            }
        }
        return count == 0;
    }
}
