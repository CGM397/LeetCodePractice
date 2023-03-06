package Q1651TO1700.number1653;

/**
 * @author: Solution
 * @date: 2023/3/6 23:06
 * @description: minimumDeletions
 */
public class Solution {
    public int minimumDeletions(String s) {
        int leftb = 0, righta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                righta++;
            }
        }
        int res = righta;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                righta--;
            } else {
                leftb++;
            }
            res = Math.min(res, leftb + righta);
        }
        return res;
    }
}
