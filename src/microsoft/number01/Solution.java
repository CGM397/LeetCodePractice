package microsoft.number01;

/**
 * @author: Bright Chan
 * @date: 2021/9/20 19:13
 * @description: TODO
 */
public class Solution {
    public String solution(String S) {
        int[] storeLower = new int[26];
        int[] storeUpper = new int[26];

        for (char one : S.toCharArray()) {
            if (one <= 90) {
                storeUpper[one - 65]++;
            }
            else {
                storeLower[one - 97]++;
            }
        }

        String res = "NO";
        for (int i = 25; i >= 0; i--) {
            if (storeLower[i] >= 1 && storeUpper[i] >= 1) {
                res = (char) (i + 65) + "";
                break;
            }
        }

        return res;
    }
}
