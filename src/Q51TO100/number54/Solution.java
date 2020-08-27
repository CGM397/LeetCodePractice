package Q51TO100.number54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/27 17:24
 * @description: 数组
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length < 1) return res;
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1, endCol = matrix[0].length - 1;

        //每次走一圈
        while (startRow <= endRow && startCol <= endCol) {
            //每次走的步数
            int steps;
            if (startRow == endRow) steps = endCol - startCol + 1;
            else if (startCol == endCol) steps = endRow - startRow + 1;
            else steps = (endRow - startRow + endCol - startCol) * 2;

            int row = startRow, col = startCol;

            for (int i = 0; i < steps; i++) {
                res.add(matrix[row][col]);
                //上边：左往右
                if (row == startRow) {
                    if (col < endCol) col++;
                    else row++;
                    continue;
                }
                //右边：上往下
                if (col == endCol) {
                    if (row < endRow) row++;
                    else col--;
                    continue;
                }
                //下边：右往左
                if (row == endRow) {
                    if (col > startCol) col--;
                    else row--;
                    continue;
                }
                //左边：下往上
                if (col == startCol) {
                    if (row > startRow) row--;
                    else col++;     //实际上走不到这一步
                }
            }
            //进入里面一圈
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return res;
    }
}
