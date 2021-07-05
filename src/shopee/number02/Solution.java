package shopee.number02;

/**
 * @author: Bright Chan
 * @date: 2021/7/5 15:23
 * @description: dfs
 */
public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param rooms int整型二维数组 房间
     * @param startPoint int整型一维数组 起始点
     * @param endPoint int整型一维数组 终点
     * @return int整型
     */
    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        dfs(visited, rooms, startPoint, endPoint);
        return res;
    }

    private int res = Integer.MAX_VALUE, oneRes = 1, curHp = 1;

    private void dfs(boolean[][] visited, int[][] rooms, int[] curPoint, int[] endPoint) {
        visited[curPoint[0]][curPoint[1]] = true;
        int tmpHp = curHp, tmpRes = oneRes;
        curHp += rooms[curPoint[0]][curPoint[1]];
        if (curHp < 1) {
            oneRes += 1 - curHp;
            curHp = 1;
        }

        if (oneRes >= res) {
            curHp = tmpHp;
            oneRes = tmpRes;
            visited[curPoint[0]][curPoint[1]] = false;
            return;
        }

        if (curPoint[0] == endPoint[0] && curPoint[1] == endPoint[1]) {
            res = oneRes;
            curHp = tmpHp;
            oneRes = tmpRes;
            visited[curPoint[0]][curPoint[1]] = false;
            return;
        }

        if (curPoint[0] - 1 >= 0) {
            if (!visited[curPoint[0] - 1][curPoint[1]]) {
                dfs(visited, rooms, new int[]{curPoint[0] - 1, curPoint[1]}, endPoint);
            }
        }
        if (curPoint[0] + 1 < rooms.length) {
            if (!visited[curPoint[0] + 1][curPoint[1]]) {
                dfs(visited, rooms, new int[]{curPoint[0] + 1, curPoint[1]}, endPoint);
            }
        }
        if (curPoint[1] - 1 >= 0) {
            if (!visited[curPoint[0]][curPoint[1] - 1]) {
                dfs(visited, rooms, new int[]{curPoint[0], curPoint[1] - 1}, endPoint);
            }
        }
        if (curPoint[1] + 1 < rooms[0].length) {
            if (!visited[curPoint[0]][curPoint[1] + 1]) {
                dfs(visited, rooms, new int[]{curPoint[0], curPoint[1] + 1}, endPoint);
            }
        }

        curHp = tmpHp;
        oneRes = tmpRes;
        visited[curPoint[0]][curPoint[1]] = false;
    }
}
