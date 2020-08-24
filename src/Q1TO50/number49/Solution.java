package Q1TO50.number49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/22 17:12
 * @description: 字符串，可以对字符串中的字符进行排序然后再比较
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length < 1) return res;

        boolean[] flag = new boolean[strs.length];
        Arrays.fill(flag, false);

        for (int i = 0; i < strs.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                String str = strs[i];
                List<String> one = new ArrayList<>();
                one.add(str);

                for (int j = i + 1; j < strs.length; j++) {
                    String tmp = strs[j];
                    if (tmp.length() == str.length()) {
                        int k = 0;
                        boolean[] isCompared = new boolean[str.length()];
                        Arrays.fill(isCompared, false);

                        // compare
                        for (; k < str.length(); k++) {
                            char charOne = str.charAt(k);
                            boolean find = false;
                            for (int z = 0; z < tmp.length(); z++) {
                                if (charOne == tmp.charAt(z) && !isCompared[z]) {
                                    isCompared[z] = true;
                                    find = true;
                                    break;
                                }
                            }
                            if (!find) break;
                        }

                        if (k == str.length()) {
                            one.add(tmp);
                            flag[j] = true;
                        }
                    }
                }
                res.add(one);
            }
        }
        return res;
    }
}
