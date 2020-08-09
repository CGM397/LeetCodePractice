package Q51TO100.number93;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/8/9 13:20
 * @description: 回溯算法
 */
public class Solution {

    // 存储单个字符的集合建议使用栈，这样可以方便在回溯时删除最后一个元素
    private Stack<String> store = new Stack<>();

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 防止给定的字符串过长或者过短，过长的坏处是，在回溯方法中，
        // 将子串转换成数字会溢出。
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        backTracking(0, s);
        return res;
    }

    private void backTracking(int nextPos, String s) {
        if (store.size() == 4 && nextPos < s.length()) return;
        if (nextPos == s.length()) {
            if (store.size() == 4) {
                String oneRes = "";
                for (String one : store) {
                    oneRes = oneRes.concat(one);
                }
                oneRes = oneRes.substring(0, oneRes.length() - 1);
                res.add(oneRes);
            }
            return;
        }

        for (int i = nextPos; i < s.length(); i++) {
            String substr = s.substring(nextPos, i + 1);
            if (substr.startsWith("0") && substr.length() > 1) continue;
            long num = Long.parseLong(substr);
            if (num >= 0 && num <= 255) {
                store.push(substr + ".");
                backTracking(i + 1, s);
                store.pop();
            }
        }
    }
}
