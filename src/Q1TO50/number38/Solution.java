package Q1TO50.number38;

/**
 * @author: Bright Chan
 * @date: 2020/8/8 20:37
 * @description: 字符串处理
 */
public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = findNext(res);
        }
        return res;
    }

    private String findNext(String str) {
        String res = "";
        int count = 0;
        str = str.concat("#");
        for (int i = 0; i < str.length() - 1; i++) {
            count++;
            if (str.charAt(i) != str.charAt(i + 1)) {
                res = res.concat(String.valueOf(count)).concat(String.valueOf(str.charAt(i)));
                count = 0;
            }
        }
        return res;
    }
}
