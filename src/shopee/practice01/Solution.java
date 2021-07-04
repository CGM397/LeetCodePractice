package shopee.practice01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/7/4 15:47
 * @description: 字符串
 */
public class Solution {
    public int romanToInt (String s) {
        int res = 0;

        char[] store = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < store.length; i++) {
            char one = store[i];
            if (one == 'I' && i < store.length - 1) {
                if (store[i + 1] == 'V') res += 4;
                else if (store[i + 1] == 'X') res += 9;
                else {
                    res += map.get(one);
                    i--;
                }
            }
            else if (one == 'X' && i < store.length - 1) {
                if (store[i + 1] == 'L') res += 40;
                else if (store[i + 1] == 'C') res += 90;
                else {
                    res += map.get(one);
                    i--;
                }
            }
            else if (one == 'C' && i < store.length - 1) {
                if (store[i + 1] == 'D') res += 400;
                else if (store[i + 1] == 'M') res += 900;
                else {
                    res += map.get(one);
                    i--;
                }
            }
            else {
                res += map.get(one);
                i--;
            }
            i++;
        }
        return res;
    }
}
