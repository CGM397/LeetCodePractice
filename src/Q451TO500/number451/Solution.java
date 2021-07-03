package Q451TO500.number451;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/7/3 15:41
 * @description: 排序
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> store = new HashMap<>();
        for (char one : s.toCharArray()) {
            store.put(one, store.getOrDefault(one, 0) + 1);
        }

        int count = 0;
        StringBuilder res = new StringBuilder();
        while (count < store.size()) {
            char maxChar = ' ';
            int maxNum = 0;
            for (Map.Entry<Character, Integer> entry : store.entrySet()) {
                if (entry.getValue() > maxNum) {
                    maxChar = entry.getKey();
                    maxNum = entry.getValue();
                }
            }
            store.put(maxChar, 0);

            for (int i = 0; i < maxNum; i++) {
                res.append(maxChar);
            }
            count++;
        }
        return res.toString();
    }
}
