package Q51TO100.number59;

/**
 * @author: Bright Chan
 * @date: 2020/9/4 22:33
 * @description: 模拟
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1, endCol = matrix[0].length - 1, count = 1;

        //每次走一圈
        while (startRow <= endRow && startCol <= endCol) {
            //每次走的步数
            int steps;
            if (startRow == endRow) steps = endCol - startCol + 1;
            else if (startCol == endCol) steps = endRow - startRow + 1;
            else steps = (endRow - startRow + endCol - startCol) * 2;

            int row = startRow, col = startCol;

            for (int i = 0; i < steps; i++) {
                matrix[row][col] = count;
                count++;
                if (row == startRow) {
                    if (col < endCol) col++;
                    else row++;
                    continue;
                }
                if (col == endCol) {
                    if (row < endRow) row++;
                    else col--;
                    continue;
                }
                if (row == endRow) {
                    if (col > startCol) col--;
                    else row--;
                    continue;
                }
                if (col == startCol) {
                    if (row > startRow) row--;
                    else col++;     //实际上走不到这一步
                }
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return matrix;
    }
}
