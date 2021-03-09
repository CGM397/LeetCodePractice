package Q1001TO1050.number1047;

import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2021/3/9 19:22
 * @description: 栈
 */
public class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> store = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!store.isEmpty() && store.peek() == c) {
                store.pop();
            }
            else {
                store.push(c);
            }
        }
        StringBuilder s = new StringBuilder();
        while (!store.isEmpty()) {
            s.append(store.pop());
        }
        return s.reverse().toString();
    }
}
