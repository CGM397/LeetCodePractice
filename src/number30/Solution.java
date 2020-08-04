package number30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/1 15:50
 * @description: 子串匹配
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;

        int num = words.length;
        int len = words[0].length();
        ArrayList<String> wordsStore = new ArrayList<>(num);
        boolean flag;

        Collections.addAll(wordsStore, words);

        for (int i = 0; i <= s.length() - (num * len); i++) {
            //重置
            flag = false;
            for (int j = 0; j < num; j++) {
                wordsStore.set(j, words[j]);
            }

            for (int k = 0; k < num; k++) {
                String substr = s.substring(i + k * len, i + (k + 1) * len);
                int index = wordsStore.indexOf(substr);
                if (index == -1) {
                    break;
                }
                wordsStore.set(index, "#");
                if (k == num - 1) flag = true;
            }

            if (flag) res.add(i);
        }
        return res;
    }
}
