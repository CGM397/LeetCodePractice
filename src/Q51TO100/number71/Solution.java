package Q51TO100.number71;

import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/10/3 15:36
 * @description: 栈
 */
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() < 1) return "/";
        Stack<String> store = new Stack<>();
        String[] splitPath = path.split("/");
        for (String s : splitPath) {
            if (s.length() < 1 || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!store.empty())
                    store.pop();
            }
            else store.push(s);
        }
        StringBuilder res = new StringBuilder();
        for (String s : store) {
            res.append("/");
            res.append(s);
        }
        if (res.length() < 1) res.append("/");
        return res.toString();
    }
}
