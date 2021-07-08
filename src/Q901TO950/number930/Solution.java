package Q901TO950.number930;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/7/8 20:16
 * @description: 哈希表
 */
public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }
}
