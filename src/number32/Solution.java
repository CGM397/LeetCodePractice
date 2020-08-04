package number32;

/**
 * @author: Bright Chan
 * @date: 2020/8/3 17:05
 * @description: 正逆向结合搜索
 */
public class Solution {
    public int mySlowMethod(String s) {
        if (s == null || s.length() <= 1) return 0;
        //用来记录左右括号，左括号加一，右括号减一
        //大于等于0继续，小于0停止
        int count = 0;
        int countLen = 0;
        //记录i的上一次位置
        int j = 0;
        int len = s.length();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
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
            if (count == 0)
                maxLen = Math.max(countLen, maxLen);
            // 搜索了到字符串末尾之后，count仍然大于0，
            // 则从这一次搜索的起始下标后一位开始搜索
            // 这样耗时太长，技巧见下面方法：逆向搜索
            if (count > 0 && i == len - 1) {
                if (maxLen > len - j) {
                    break;
                }
                count = 0;
                countLen = 0;
                i = j;
                j++;
            }
        }
        return maxLen;
    }

    // 正逆向相结合搜索，比上面的方法快500倍 :(
    // 参考的是官方解答的第三种方法
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        int count = 0;
        int countLen = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
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
                }
                else countLen++;
            }
            if (count == 0)
                maxLen = Math.max(countLen, maxLen);
        }

        count = countLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                count++;
                countLen++;
            }
            else if (s.charAt(i) == '(') {
                count--;
                if (count < 0) {
                    //重置
                    count = 0;
                    countLen = 0;
                }
                else countLen++;
            }
            if (count == 0)
                maxLen = Math.max(countLen, maxLen);
        }
        return maxLen;
    }

    //判断有效括号的方法
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
