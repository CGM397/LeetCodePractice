package Q1001TO1050.number1018;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/1/14 10:32
 * @description: 数组
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();

        int num = 0;
        for (int value : A) {
            num <<= 1;
            num += value;
            num %= 10;
            ans.add(num % 5 == 0);
        }

        return ans;
    }
}
