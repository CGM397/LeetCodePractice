package Q501TO550.number547;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/1/7 11:16
 * @description: 图，dfs
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] flag = new boolean[len];
        Arrays.fill(flag, false);

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (!flag[i]) {
                dfs(i, isConnected, flag);
                res++;
            }
        }

        return res;
    }

    private void dfs (int i, int[][] isConnected, boolean[] flag) {
        flag[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (!flag[j] && isConnected[i][j] == 1) {
                dfs(j, isConnected, flag);
            }
        }
    }
}
