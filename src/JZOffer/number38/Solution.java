package JZOffer.number38;


import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/2/17 10:48
 * @description: dfs
 */
public class Solution {
    public String[] permutation(String s) {
        char[] store = s.toCharArray();
        boolean[] flag = new boolean[store.length];
        Arrays.fill(flag, false);

        dfs(store, flag);
        String[] result = new String[res.size()];
        Iterator<String> iterator = res.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            result[count] = iterator.next();
            count++;
        }
        return result;
    }

    private Set<String> res = new HashSet<>();
    private Stack<Character> one = new Stack<>();

    private void dfs(char[] store, boolean[] flag) {
        if (one.size() == store.length) {
            StringBuilder tmp = new StringBuilder();
            for (char c : one) tmp.append(c);
            res.add(tmp.toString());
        }
        else {
            for (int i = 0; i < store.length; i++) {
                if (!flag[i]) {
                    flag[i] = true;
                    one.push(store[i]);
                    dfs(store, flag);
                    one.pop();
                    flag[i] = false;
                }
            }
        }
    }
}
