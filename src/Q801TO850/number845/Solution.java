package Q801TO850.number845;

/**
 * @author: Bright Chan
 * @date: 2020/10/25 10:29
 * @description: 数组
 */
public class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) return 0;

        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int cur = A[i];
            if (cur < A[i + 1]) {
                int j = i + 1;
                while (j < A.length && A[j] > A[j - 1]) j++;
                if (j < A.length && A[j] < A[j - 1]) {
                    while (j < A.length && A[j] < A[j - 1]) j++;
                    res = Math.max(res, j - i);
                }
                i = j - 2;
            }
        }
        return res;
    }
}
