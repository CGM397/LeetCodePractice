package Q1701TO1750.number1736;

/**
 * @author: Bright Chan
 * @date: 2021/7/24 16:41
 * @description: 模拟
 */
public class Solution {
    public String maximumTime(String time) {
        String res = "";
        if (time.charAt(0) == '?') {
            if ((time.charAt(1) >= '0' && time.charAt(1) <= '3') || time.charAt(1) == '?') {
                res += "2";
            }
            else {
                res += "1";
            }
        }
        else {
            res += time.charAt(0);
        }

        if (time.charAt(1) == '?') {
            if (time.charAt(0) == '2' || time.charAt(0) == '?') {
                res += "3";
            }
            else {
                res += "9";
            }
        }
        else {
            res += time.charAt(1);
        }

        res += ':';

        res += time.charAt(3) == '?' ? '5' : time.charAt(3);

        res += time.charAt(4) == '?' ? '9' : time.charAt(4);

        return res;
    }
}
