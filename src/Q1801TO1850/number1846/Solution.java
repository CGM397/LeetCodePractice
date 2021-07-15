package Q1801TO1850.number1846;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/7/15 21:11
 * @description: 贪心
 */
public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; ++i) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[n - 1];
    }
}
