package Q301TO350.number304;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/3/2 10:38
 * @description: 数组
 */
public class NumMatrix {

    private int[][] store;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            store = new int[0][0];
            return;
        }
        store = new int[matrix.length + 1][matrix[0].length + 1];
        Arrays.fill(store[0], 0);
        for (int i = 0; i < store.length; i++) {
            store[i][0] = 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                store[i + 1][j + 1] = store[i][j + 1] + store[i + 1][j] - store[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return store[row2 + 1][col2 + 1] - store[row2 + 1][col1] - store[row1][col2 + 1]
                + store[row1][col1];
    }
}
