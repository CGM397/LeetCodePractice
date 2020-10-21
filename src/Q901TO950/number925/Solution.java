package Q901TO950.number925;

/**
 * @author: Bright Chan
 * @date: 2020/10/21 9:39
 * @description: 字符串
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) return false;

        int i = 0, j = 0;
        char pre = '#';

        while (i < name.length() && j < typed.length()) {
            char cur = name.charAt(i);

            if (typed.charAt(j) == cur) {
                pre = cur;
                j++;
            }
            else {
                if (typed.charAt(j) == pre) {
                    while (j < typed.length() && typed.charAt(j) == pre) j++;
                    if (j == typed.length() || typed.charAt(j) != cur) return false;
                    pre = cur;
                    j++;
                }
                else return false;
            }

            i++;
        }

        if (i == name.length() && j < typed.length()) {
            while (j < typed.length() && typed.charAt(j) == pre) j++;
        }

        return j == typed.length() && i == name.length();
    }
}
