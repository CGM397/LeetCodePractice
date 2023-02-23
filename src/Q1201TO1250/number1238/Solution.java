package Q1201TO1250.number1238;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Solution
 * @date: 2023/2/23 22:19
 * @description: circularPermutation
 */
public class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i ^ start);
        }
        return ret;
    }
}
