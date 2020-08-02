package number30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/1 15:50
 * @description: TODO
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;

        int num = words.length;
        int len = words[0].length();
//        ArrayList<Character> starts = new ArrayList<>(num);
        ArrayList<String> wordsStore = new ArrayList<>(num);
        int[] tmpStore = new int[num];
        boolean flag;

        Collections.addAll(wordsStore, words);
//        for (String word : words) {
//            starts.add(word.charAt(0));
//            wordsStore.add(word);
//        }

        for (int i = 0; i <= s.length() - (num * len); i++) {
            //重置
            flag = false;
            for (int j = 0; j < num; j++) {
//                starts.set(j, words[j].charAt(0));
                wordsStore.set(j, words[j]);
                tmpStore[j] = 0;
            }
//            //首先查看首字母是否匹配
//            for (int k = 0; k < num; k++) {
//                int index = starts.indexOf(s.charAt(i + k * len));
//                if (index == -1 || tmpStore[index] > 0) {
//                    break;
//                }
//                tmpStore[index]++;
//                //防止有首字母重复的
//                starts.set(index, '#');
//                if (k == num - 1) flag = true;
//            }
//            //如果首字母匹配，则进行字符串比较
//            if (flag) {
//                for (int k = 0; k < num; k++) {
//                    String substr = s.substring(i + k * len, i + (k + 1) * len - 1);
//                    int index = wordsStore.indexOf(substr);
//                    if (index == -1 || tmpStore[index] > 0) {
//                        break;
//                    }
//                    tmpStore[index]++;
//                    wordsStore.set(index, "#");
//                    if (k == num - 1) flag = true;
//                }
//            }
            for (int k = 0; k < num; k++) {
                String substr = s.substring(i + k * len, i + (k + 1) * len - 1);
                int index = wordsStore.indexOf(substr);
                if (index == -1) {
                    break;
                }
                tmpStore[index]++;
                wordsStore.set(index, "#");
                if (k == num - 1) flag = true;
            }

            if (flag) res.add(i);
        }
        return res;
    }
}
