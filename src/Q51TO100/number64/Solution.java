package Q51TO100.number64;

/**
 * @author: Bright Chan
 * @date: 2020/9/9 21:39
 * @description: 动态规划
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] store = new int[grid.length][grid[0].length];
        store[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            store[i][0] = store[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            store[0][i] = store[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                store[i][j] = grid[i][j] + Math.min(store[i - 1][j], store[i][j - 1]);
            }
        }
        return store[grid.length - 1][grid[0].length - 1];
    }
}
