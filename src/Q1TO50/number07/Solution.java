package Q1TO50.number07;

/**
 * @author: Bright Chan
 * @date: 2021/5/4 17:39
 * @description: 数字
 */
public class Solution {
    public int reverse(int x) {
        boolean isNag = x < 0;
        String str = String.valueOf(x);
        str = isNag ? str.substring(1) : str;
        int res = 0, len = str.length();
        if (len >= 10 && str.charAt(len - 1) > 50) return 0;
        while (len > 0) {
            res = res + (int) ((str.charAt(len - 1) - 48) * Math.pow(10, len - 1));
            if (res < 0) return 0;
            len--;
        }
        return isNag ? -res : res;
    }
}
