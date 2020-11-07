package Q301TO350.number327;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/11/7 8:03
 * @description: 排序
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            long ini = nums[i];
            if (ini >= lower && ini <= upper) count++;
            for (int j = i + 1; j < len; j++) {
                ini = ini + (long) nums[j];
                if (ini >= lower && ini <= upper) count++;
            }
        }

        return count;
    }
}
