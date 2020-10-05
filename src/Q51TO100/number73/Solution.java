package Q51TO100.number73;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/10/5 10:49
 * @description: 数组
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
        // 第0行、第0列是否需要被置为0；matrix[0][0]是否原本就是0
        boolean row0 = false, col0 = false, origin = matrix[0][0] == 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row0 = true;
                    else if (j == 0) col0 = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) matrix[j][i] = 0;
            }
        }
        if (matrix[0][0] == 0) {
            if (origin) {
                Arrays.fill(matrix[0], 0);
                for (int i = 1; i < matrix.length; i++) matrix[i][0] = 0;
            }
            else {
                if (row0) {
                    Arrays.fill(matrix[0], 0);
                }
                if (col0) {
                    for (int i = 1; i < matrix.length; i++) matrix[i][0] = 0;
                }
            }
        }
    }
}
