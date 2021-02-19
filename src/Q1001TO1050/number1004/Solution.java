package Q1001TO1050.number1004;

/**
 * @author: Bright Chan
 * @date: 2021/2/19 10:21
 * @description: 滑动窗口
 */
public class Solution {
    public int longestOnes(int[] A, int K) {
        int tmp = K, len = A.length, left = 0, right = 0, res = 0, count = 0;

        while (right < len) {
            if (A[right] == 0) {
                if (tmp == 0) {
                    res = Math.max(res, count);
                    int store = left;
                    while (left < len && A[left] == 1) left++;
                    left++;
                    right--;
                    tmp++;
                    count = count - (left - store);
                }
                else {
                    tmp--;
                    count++;
                }
            }
            else {
                count++;
            }
            right++;
        }
        return Math.max(res, count);
    }
}
