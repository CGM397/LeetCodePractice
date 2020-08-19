package Q601TO650.number647;

/**
 * @author: Bright Chan
 * @date: 2020/8/19 13:36
 * @description: 回文子串，可使用Manacher算法
 */
public class Solution {

    private int res = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) return res;

        for (int i = 0; i < s.length() - 1; i++) {
            findPalindrome(s, i, i);
            findPalindrome(s, i, i + 1);
        }
        return res + 1;
    }

    private void findPalindrome(String s, int low, int high) {
        while (low >= 0 && high < s.length()){
            if(s.charAt(low) == s.charAt(high)){
                res++;
                low --;
                high ++;
            }
            else
                break;
        }
    }
}
