package Q51TO100.number63;

/**
 * @author: Bright Chan
 * @date: 2020/9/9 10:21
 * @description: 动态规划
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] store = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0) store[0][i] = 1;
            else {
                for (int j = i; j < obstacleGrid[0].length; j++) store[0][j] = 0;
                break;
            }
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0) store[i][0] = 1;
            else {
                for (int j = i; j < obstacleGrid.length; j++) store[j][0] = 0;
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0)
                    store[i][j] = store[i - 1][j] + store[i][j - 1];
                else
                    store[i][j] = 0;
            }
        }

        return store[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
