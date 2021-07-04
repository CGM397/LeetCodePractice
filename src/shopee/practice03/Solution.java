package shopee.practice03;

/**
 * @author: Bright Chan
 * @date: 2021/7/4 16:51
 * @description: 递归
 */
public class Solution {
    public String computeString (String str) {
        if (str == null) return null;

        int left = str.indexOf('['), right = str.lastIndexOf(']');
        if (left != -1) {
            int pre = left - 2;
            while (pre >= 0 && Character.isDigit(str.charAt(pre))) {
                pre--;
            }
            int k = Integer.parseInt(str.substring(pre + 1, left - 1));
            String tmp = computeString(str.substring(left + 1, right));
            StringBuilder res = new StringBuilder(str.substring(0, pre + 1));
            while (k > 0) {
                res.append(tmp);
                k--;
            }
            res.append(str.substring(right + 1));
            return res.toString();
        }
        else {
            return str;
        }
    }
}
