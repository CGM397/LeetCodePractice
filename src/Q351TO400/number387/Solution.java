package Q351TO400.number387;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/12/23 10:15
 * @description: 字符串
 */
public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        Map<Character, Integer> store = new HashMap<>();
        for (char c : s.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (store.get(c) == 1) return s.indexOf(c);
        }

        return -1;
    }
}
