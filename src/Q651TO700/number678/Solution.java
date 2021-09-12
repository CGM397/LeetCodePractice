package Q651TO700.number678;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/9/12 16:11
 * @description: 栈
 */
public class Solution {
    public boolean checkValidString(String s) {
        char[] store = s.toCharArray();
        char[] reverse = new char[store.length];
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put(')', '(');
        map.put('*', '*');
        for (int i = 0; i < store.length; i++) {
            reverse[i] = map.get(store[store.length - 1 - i]);
        }

        return getRes(store) && getRes(reverse);
    }

    private boolean getRes(char[] store) {
        int count = 0, patterns = 0;
        for (char one : store) {
            if (one == '(') count++;
            if (one == '*') patterns++;
            if (one == ')') {
                if (count > 0) {
                    count--;
                }
                else {
                    if (patterns > 0) {
                        patterns--;
                    }
                    else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
