package shopee.practice05;

/**
 * @author: Bright Chan
 * @date: 2021/7/4 21:17
 * @description: 字符串
 */
public class Solution {
    public boolean checkValidString (String s) {

        int l = 0, r = 0;
        for(int i = 0; i < s.length(); i++){
            l+=s.charAt(i) == ')' ? -1 : 1;
            r+=s.charAt(s.length() - 1 - i) == '(' ? -1: 1;
            if(l < 0 || r < 0)
                return false;
        }
        return true;
    }
}
