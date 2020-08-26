package Q1TO50.number17;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 9:51
 * @description: 回溯
 */
public class Solution {

    private Map<Character, String> store = new HashMap<>();
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) return res;
        store.put('2', "abc");
        store.put('3', "def");
        store.put('4', "ghi");
        store.put('5', "jkl");
        store.put('6', "mno");
        store.put('7', "pqrs");
        store.put('8', "tuv");
        store.put('9', "wxyz");

        backTracking(0, digits, new Stack<>());
        return res;
    }

    private void backTracking(int pos, String digits, Stack<Character> one) {
        if (pos == digits.length()) {
            StringBuilder oneRes = new StringBuilder();
            for (Character c : one) oneRes.append(c);
            res.add(oneRes.toString());
            return;
        }

        String tmp = store.get(digits.charAt(pos));
        for (int i = 0; i < tmp.length(); i++) {
            one.push(tmp.charAt(i));
            backTracking(pos + 1, digits, one);
            one.pop();
        }
    }
}
