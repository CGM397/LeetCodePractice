package Q801TO850.number844;

import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/10/19 10:27
 * @description: 栈
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return false;

        Stack<Character> one = new Stack<>();
        Stack<Character> two = new Stack<>();

        for (char i : S.toCharArray()) {
            if (i == '#') {
                if (!one.empty()) one.pop();
            }
            else one.push(i);
        }

        for (char i : T.toCharArray()) {
            if (i == '#') {
                if (!two.empty()) two.pop();
            }
            else two.push(i);
        }
        if (one.size() != two.size()) return false;
        for (int i = 0; i < one.size(); i++) {
            if (one.get(i) != two.get(i)) return false;
        }
        return true;
    }
}
