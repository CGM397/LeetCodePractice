package Q1TO50.number48;

/**
 * @author: Bright Chan
 * @date: 2020/8/22 16:23
 * @description: 数组旋转
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int tmp1, tmp2, tmp3, len = matrix.length;
        // 每次对最外面一层正方形做操作，直到最里面(单个元素或者四个元素)
        for (int i = 0; i < len / 2; i++) {
            // 找到需要操作的正方形，
            // 这边注意：不能遍历到每条边上的最后一个元素，不然四个角会多交换一次
            for (int j = i; j < len - i - 1; j++) {
                // 上转到右
                tmp1 = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = matrix[i][j];
                // 右转到下
                tmp2 = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = tmp1;
                // 下转到左
                tmp3 = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = tmp2;
                // 左转到上
                matrix[i][j] = tmp3;
            }
        }
    }
}
