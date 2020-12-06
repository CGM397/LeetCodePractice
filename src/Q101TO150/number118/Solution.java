package Q101TO150.number118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/12/6 10:03
 * @description: 杨辉三角
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        res.add(pre);

        int count = 1;
        while (count < numRows) {
            count++;
            List<Integer> cur = new ArrayList<>(count);
            cur.add(1);
            for (int i = 0; i < pre.size(); i++) {
                int one = pre.get(i);
                int two = i + 1 >= pre.size() ? 0 : pre.get(i + 1);
                cur.add(one + two);
            }
            res.add(cur);
            pre = cur;
        }
        return res;
    }
}
