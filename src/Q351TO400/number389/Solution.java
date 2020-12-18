package Q351TO400.number389;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/12/18 9:52
 * @description: 字符串
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);

        Map<Character, Integer> store = new HashMap<>();

        for (char c : s.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!store.containsKey(c) || store.get(c) == 0) return c;
            else
                store.put(c, store.get(c) - 1);
        }
        return 'a';
    }
}
