package interview.number1705;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Solution
 * @date: 2023/3/11 15:59
 * @description: findLongestSubarray
 */
public class Solution {
    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> indices = new HashMap<>();
        indices.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        int startIndex = -1;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            if (indices.containsKey(sum)) {
                int firstIndex = indices.get(sum);
                if (i - firstIndex > maxLength) {
                    maxLength = i - firstIndex;
                    startIndex = firstIndex + 1;
                }
            } else {
                indices.put(sum, i);
            }
        }
        if (maxLength == 0) {
            return new String[0];
        }
        String[] ans = new String[maxLength];
        System.arraycopy(array, startIndex, ans, 0, maxLength);
        return ans;
    }
}
