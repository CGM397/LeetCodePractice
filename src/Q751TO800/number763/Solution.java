package Q751TO800.number763;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/10/22 11:08
 * @description: 贪心算法
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() < 2) return res;

        int i = 0, j, maxIndex;
        while (i < S.length()) {
            char cur = S.charAt(i);
            j = S.lastIndexOf(cur);
            maxIndex = j;
            for (int k = i + 1; k < maxIndex; k++) {
                char selected = S.charAt(k);
                if (selected != cur) {
                    maxIndex = Math.max(maxIndex, S.lastIndexOf(selected));
                }
            }
            res.add(maxIndex - i + 1);
            i = maxIndex + 1;
        }

        return res;
    }
}
