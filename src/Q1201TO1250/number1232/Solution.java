package Q1201TO1250.number1232;

/**
 * @author: Bright Chan
 * @date: 2021/1/19 15:52
 * @description: 数组
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean hasK = coordinates[0][0] != coordinates[1][0];

        double k = 0;
        if (hasK) {
            k = ((double) coordinates[0][1] - (double) coordinates[1][1]) /
                    (coordinates[0][0] - (double) coordinates[1][0]);
        }
        double x = coordinates[0][0], y = coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            double curX = coordinates[i][0], curY = coordinates[i][1];

            if (hasK) {
                if (curX == x) return false;

                double curK = (y - curY) / (x - curX);
                if (curK != k) return false;
            }
            else {
                if (curX != x) return false;
            }
        }
        return true;
    }
}
