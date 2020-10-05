package Q51TO100.number74;

/**
 * @author: Bright Chan
 * @date: 2020/10/5 14:51
 * @description: 二分查找
 */
public class Solution {
    public boolean mySlowMethod(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;

        int row = -1;
        for (int i = 0; i < matrix.length - 1; i++) {
            if (target >= matrix[i][0] && target < matrix[i + 1][0]) {
                row = i;
            }
        }
        if (row == -1) row = matrix.length - 1;

        for (int j = 0; j < matrix[0].length; j++) {
            if (target == matrix[row][j]) return true;
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}
