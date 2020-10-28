package Q1201TO1250.number1207;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/10/28 11:23
 * @description: 哈希表
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        Map<Integer, Integer> store = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (store.containsKey(entry.getValue())) return false;
            else store.put(entry.getValue(), 1);
        }
        return true;
    }
}
