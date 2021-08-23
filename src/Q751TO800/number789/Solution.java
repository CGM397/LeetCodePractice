package Q751TO800.number789;

/**
 * @author: Bright Chan
 * @date: 2021/8/22 18:19
 * @description: 曼哈顿距离
 */
public class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = {0, 0};
        int distance = manhattanDistance(source, target);
        for (int[] ghost : ghosts) {
            int ghostDistance = manhattanDistance(ghost, target);
            if (ghostDistance <= distance) {
                return false;
            }
        }
        return true;
    }

    public int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
