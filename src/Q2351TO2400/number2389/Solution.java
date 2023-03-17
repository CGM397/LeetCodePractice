package Q2351TO2400.number2389;

import java.util.Arrays;

/**
 * @author: Solution
 * @date: 2023/3/17 22:34
 * @description: answerQueries
 */
public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] store = new int[nums.length];
        store[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            store[i] = nums[i] + store[i - 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int current = queries[i];
            int j = nums.length - 1;
            while (j >= 0 && store[j] > current) {
                j--;
            }
            res[i] = j + 1;
        }
        return res;
    }
}
