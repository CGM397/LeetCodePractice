package Q451TO500.number463;

/**
 * @author: Bright Chan
 * @date: 2020/10/30 10:42
 * @description: 数组
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int one = grid[i][j];
                if (one == 1) {
                    int count = 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) count--;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) count--;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) count--;
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) count--;
                    res += count;
                }
            }
        }
        return res;
    }
}
