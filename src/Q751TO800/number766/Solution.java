package Q751TO800.number766;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/2/22 12:26
 * @description: 数组
 */
public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int len = matrix.length, len0 = matrix[0].length;

        int[] store = new int[len0 - 1];
        System.arraycopy(matrix[0], 0, store, 0, len0 - 1);

        for (int i = 1; i < len; i++) {
            int[] tmp = new int[len0 - 1];
            System.arraycopy(matrix[i], 1, tmp, 0, len0 - 1);
            if (!Arrays.equals(store, tmp)) return false;

            System.arraycopy(matrix[i], 0, store, 0, len0 - 1);
        }
        return true;
    }
}
