package Q401TO450.number402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Bright Chan
 * @date: 2020/11/15 11:21
 * @description: 贪心
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    public String mySlowMethod(String num, int k) {
        if (k == num.length()) return "0";
        StringBuilder res = new StringBuilder();

        int start = 0;
        while (k > 0) {

            int minNumIndex = -1, minNum = 10;
            for (int i = start; i < num.length() && i <= start + k; i++) {
                int tmp = Integer.parseInt(num.charAt(i) + "");
                if (tmp < minNum) {
                    minNum = tmp;
                    minNumIndex = i;
                }
            }

            if (minNum > 0 || res.length() > 0) res.append(minNum);
            for (int i = start; i < minNumIndex; i++) {
                k--;
            }
            start = minNumIndex + 1;

            if (start >= num.length()) break;
        }

        if (start >= num.length() && k > 0) {
            while (k > 0) {
                k--;
                res.deleteCharAt(res.length() - 1);
            }
        }
        if (start < num.length()) res.append(num.substring(start));
        if (res.length() == 0) res.append(0);
        return res.toString();
    }
}
