package Q201TO250.number214;

/**
 * @author: Bright Chan
 * @date: 2020/8/29 10:24
 * @description: KMP算法
 */
public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 1) return s;
        //getNext
        char[] storeP = s.toCharArray();
        int[] next = new int[s.length()];
        next[0] = -1;
        int j = 0, k = -1;
        while (j < s.length() - 1) {
            if (k == -1 || storeP[j] == storeP[k]) {
                j++;
                k++;
                if (storeP[j] == storeP[k])
                    next[j] = next[k];
                else
                    next[j] = k;
            }
            else
                k = next[k];
        }

        String reverse = new StringBuffer(s).reverse().toString();
        char[] storeS = reverse.toCharArray();
        int i = 0;
        j = 0;
        while (i < storeS.length && j < storeP.length) {
            if (j == -1 || storeS[i] == storeP[j]) {
                i++;
                j++;
            }
            else {
                j = next[j];
            }
        }
        String sub = new StringBuffer(s.substring(j)).reverse().toString();

        return sub + s;
    }

}
