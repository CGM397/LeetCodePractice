package Q201TO250.number242;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/11/22 10:55
 * @description: 字符串
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> store = new HashMap<>();
        for (char one : s.toCharArray()) {
            store.put(one, store.getOrDefault(one, 0) + 1);
        }

        for (char one : t.toCharArray()) {
            if (!store.containsKey(one) || store.get(one) < 1) return false;
            store.put(one, store.get(one) - 1);
        }
        return true;
    }
}
