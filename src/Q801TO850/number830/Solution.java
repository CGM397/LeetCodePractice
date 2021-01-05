package Q801TO850.number830;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/1/5 11:03
 * @description: 字符串
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s.length() < 3) return res;

        int start = 0, end = 0;

        while (end < s.length()) {
            char cur = s.charAt(start);

            while (end + 1 < s.length() && s.charAt(end + 1) == cur) end++;

            if (end - start >= 2) {
                List<Integer> one = new ArrayList<>();
                one.add(start);
                one.add(end);
                res.add(one);
            }

            end++;
            start = end;
        }
        return res;
    }
}
