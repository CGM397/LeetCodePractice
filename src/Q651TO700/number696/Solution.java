package Q651TO700.number696;

/**
 * @author: Bright Chan
 * @date: 2020/8/10 13:04
 * @description: 字符串
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int count1, count2;
        int res = 0;

        for (int  i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count1 = count2 = 1;
                int j = i, k = i + 1;
                while (j > 0 && s.charAt(j - 1) == s.charAt(j)) {
                    count1++;
                    j--;
                }
                while (k < s.length() - 1 && s.charAt(k) == s.charAt(k + 1)) {
                    count2++;
                    k++;
                }
                res += Math.min(count1 , count2);
                i = k - 1;
            }
        }
        return res;
    }
}
