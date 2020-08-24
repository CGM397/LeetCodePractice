package Q451TO500.number459;

/**
 * @author: Bright Chan
 * @date: 2020/8/24 11:53
 * @description: 字符串子串
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) return false;
        char start = s.charAt(0);
        String subStr;
        StringBuilder tmp;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == start && s.length() % i == 0) {
                subStr = s.substring(0, i);
                tmp = new StringBuilder();
                for (int j = 0; j < s.length() / i; j++)
                    tmp.append(subStr);
                if (tmp.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
