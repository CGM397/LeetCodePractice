package Q201TO250.number228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/1/11 10:37
 * @description: 数组
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length < 1) return res;
        long start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur - end > 1) {
                if (start == end) {
                    res.add(start + "");
                }
                else {
                    res.add(start + "->" + end);
                }
                start = end = cur;
            }
            else {
                end = cur;
            }
        }
        if (start == end) {
            res.add(start + "");
        }
        else {
            res.add(start + "->" + end);
        }
        return res;
    }
}
