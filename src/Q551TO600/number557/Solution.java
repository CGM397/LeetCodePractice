package Q551TO600.number557;

/**
 * @author: Bright Chan
 * @date: 2020/8/30 10:23
 * @description: 模拟
 */
public class Solution {
    public String reverseWords(String s) {
        String tmp = new StringBuffer(s).reverse().toString();
        String[] store = tmp.split(" ");
        StringBuilder res = new StringBuilder();
        boolean first = true;
        for (int i = store.length - 1; i >= 0; i--) {
            if (first) first = false;
            else res.append(" ");
            res.append(store[i]);
        }
        return res.toString();
    }
}
