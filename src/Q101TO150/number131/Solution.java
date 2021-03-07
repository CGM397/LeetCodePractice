package Q101TO150.number131;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2021/3/7 10:57
 * @description: 回溯
 */
public class Solution {

    private List<List<String>> res = new ArrayList<>();
    private Stack<String> one = new Stack<>();
    public List<List<String>> partition(String s) {
        dfs(0, s);
        return res;
    }

    private void dfs(int head, String s) {
        if (head == s.length()) {
            List<String> tmp = new ArrayList<>(one);
            res.add(tmp);
            return;
        }

        for (int i = head; i < s.length(); i++) {
            boolean flag = true;
            for (int j = head; j <= (head + i) / 2; j++) {
                if (s.charAt(j) != s.charAt(i + head - j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                String s1 = s.substring(head, i + 1);
                one.push(s1);
                dfs(i + 1, s);
                one.pop();
            }
        }
    }
}
