package Q1701TO1750.number1711;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/7/7 21:17
 * @description: 哈希表
 */
public class Solution {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}
