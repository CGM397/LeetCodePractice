package Q551TO600.number566;

/**
 * @author: Bright Chan
 * @date: 2021/2/17 10:34
 * @description: 数组
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) return nums;

        int[][] res = new int[r][c];
        int count = 0, col = nums[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[count / col][count % col];
                count++;
            }
        }
        return res;
    }
}
