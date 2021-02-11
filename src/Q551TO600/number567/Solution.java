package Q551TO600.number567;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Bright Chan
 * @date: 2021/2/10 11:38
 * @description: 滑动窗口
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> store = new HashMap<>();

        for (char c : s1.toCharArray()) store.put(c, store.getOrDefault(c, 0) + 1);

        Set<Character> keyStore = new HashSet<>(store.keySet());
        Map<Character, Integer> tmp = new HashMap<>(store);

        int left = 0, right = 0, len = s2.length();
        while (right < len) {
            if (store.isEmpty()) return true;
            
            char cur = s2.charAt(right);
            if (keyStore.contains(cur)) {
                if (store.containsKey(cur)) {
                    store.put(cur, store.get(cur) - 1);
                    if (store.get(cur) == 0) store.remove(cur);
                }
                else {
                    while (s2.charAt(left) != cur) {
                        char leftChar = s2.charAt(left);
                        store.put(leftChar, store.getOrDefault(leftChar, 0) + 1);
                        left++;
                    }
                    left++;
                }
            }
            else {
                store = new HashMap<>(tmp);
                left = right + 1;
            }
            right++;
        }

        return store.isEmpty();
    }
}
