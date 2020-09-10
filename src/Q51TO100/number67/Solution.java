package Q51TO100.number67;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/9/10 14:06
 * @description: 字符串
 */
public class Solution {
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        char[] storeA = new char[len + 1];
        char[] storeB = new char[len + 1];

        int i = 0;
        while (i < len + 1) {
            if (i <= len - a.length()) storeA[i] = '0';
            else storeA[i] = a.charAt(i - len + a.length() - 1);
            i++;
        }
        i = 0;
        while (i < len + 1) {
            if (i <= len - b.length()) storeB[i] = '0';
            else storeB[i] = b.charAt(i - len + b.length() - 1);
            i++;
        }

        int carry = 0, oneRes;
        i = len;
        Map<Character, Integer> store = new HashMap<>();
        store.put('0', 0);
        store.put('1', 1);
        for (; i >= 0; i--) {
            oneRes = carry + store.get(storeA[i]) + store.get(storeB[i]);
            if (oneRes > 1) {
                carry = 1;
                storeA[i] = oneRes == 3 ? '1' : '0';
            }
            else {
                carry = 0;
                storeA[i] = (char) (oneRes + 48);
            }
        }

        char[] res;
        if (storeA[0] == '0') {
            res = new char[len];
            System.arraycopy(storeA, 1, res, 0, len);
        }
        else {
            res = storeA;
        }
        return new String(res);
    }
}
