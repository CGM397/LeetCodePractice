package Q951TO1000.number977;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/10/16 10:50
 * @description: 数组
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length < 1) return A;
        for (int i = 0; i < A.length; i++) A[i] = A[i] * A[i];
        Arrays.sort(A);
        return A;
    }
}
