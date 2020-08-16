package Q701TO750.number733;

/**
 * @author: Bright Chan
 * @date: 2020/8/16 14:13
 * @description: 深度优先搜索
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        dfs(sr, sc, image, image[sr][sc], newColor);
        image[sr][sc] = newColor;
        return image;
    }

    private void dfs(int sr, int sc, int[][] image, int oldColor, int newColor) {
        if (sr - 1 >= 0 && image[sr - 1][sc] == oldColor) {
            image[sr - 1][sc] = newColor;
            dfs(sr - 1, sc, image, oldColor, newColor);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == oldColor) {
            image[sr + 1][sc] = newColor;
            dfs(sr + 1, sc, image, oldColor, newColor);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == oldColor) {
            image[sr][sc - 1] = newColor;
            dfs(sr, sc - 1, image, oldColor, newColor);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == oldColor) {
            image[sr][sc + 1] = newColor;
            dfs(sr, sc + 1, image, oldColor, newColor);
        }
    }
}
