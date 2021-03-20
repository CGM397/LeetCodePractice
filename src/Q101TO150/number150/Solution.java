package Q101TO150.number150;

import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2021/3/20 14:14
 * @description: 栈
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> store = new Stack<>();

        for (String cur : tokens) {
            switch (cur) {
                case "+": {
                    int x = store.pop();
                    int y = store.pop();
                    store.push(x + y);
                    break;
                }
                case "-": {
                    int x = store.pop();
                    int y = store.pop();
                    store.push(y - x);
                    break;
                }
                case "*": {
                    int x = store.pop();
                    int y = store.pop();
                    store.push(x * y);
                    break;
                }
                case "/": {
                    int x = store.pop();
                    int y = store.pop();
                    store.push(y / x);
                    break;
                }
                default:
                    store.push(Integer.parseInt(cur));
                    break;
            }
        }

        return store.pop();
    }
}
