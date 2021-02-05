package Q1201TO1250.number1208;

/**
 * @author: Bright Chan
 * @date: 2021/2/5 12:45
 * @description: 双指针
 */
public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] cost = new int[len];

        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0, right = 0, sum = 0;

        while (right < len) {
            sum += cost[right];

            if (sum > maxCost) {
                sum -= cost[left];
                left++;
            }

            right++;
        }
        return right - left;
    }
}
