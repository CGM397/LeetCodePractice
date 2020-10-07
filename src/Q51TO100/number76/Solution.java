package Q51TO100.number76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/10/7 9:57
 * @description: 滑动窗口
 */
public class Solution {
    // 保存t的所有字符的个数
    Map<Character, Integer> ori = new HashMap<>();
    // 保存滑动窗口中所有字符的个数
    Map<Character, Integer> cnt = new HashMap<>();


    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < 1 || t.length() < 1) return "";
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLen = s.length() + 1, ansL = -1, ansR = -1;

        while (right < s.length()) {
            if (ori.containsKey(s.charAt(right))) {
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);
            }

            // 处理符合条件的子串
            while (check() && left <= right) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ansL = left;
                    ansR = left + minLen;
                }
                // 窗口左端右移一位
                if (ori.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }

            right++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> characterIntegerEntry : ori.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            Integer val = characterIntegerEntry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
