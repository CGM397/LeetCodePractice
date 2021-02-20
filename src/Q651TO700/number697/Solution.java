package Q651TO700.number697;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/2/20 10:42
 * @description: 哈希表
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> store = new HashMap<>();

        int max = 0;
        for (int cur : nums) {
            store.put(cur, store.getOrDefault(cur, 0) + 1);
            if (store.get(cur) > max) max = store.get(cur);
        }

        int left = 0, right = 0, tmpMax = 0, res = nums.length;
        store.clear();
        while (right < nums.length) {
            int cur = nums[right];
            store.put(cur, store.getOrDefault(cur, 0) + 1);
            if (store.get(cur) > tmpMax) tmpMax = store.get(cur);

            if (tmpMax == max) {
                while (true) {
                    int tmp = nums[left];
                    store.put(tmp, store.get(tmp) - 1);
                    if (tmp == cur) {
                        tmpMax--;
                        break;
                    }
                    left++;
                }
                res = Math.min(res, right - left + 1);
                left++;
            }
            right++;
        }
        return res;
    }
}
