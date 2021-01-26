package Q1101TO1150.number1128;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/1/26 10:09
 * @description: 数组
 */
public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int len = dominoes.length;
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);

        int count, res = 0;
        for (int i = 0; i < len - 1; i++) {
            if (visited[i]) continue;

            int[] cur = dominoes[i];
            count = 1;
            for (int j = i + 1; j < len; j++) {
                if (visited[j]) continue;

                int[] tmp = dominoes[j];
                if ((tmp[0] == cur[0] && tmp[1] == cur[1]) || (tmp[1] == cur[0] && tmp[0] == cur[1])) {
                    count++;
                    visited[j] = true;
                }
            }

            if (count >= 2) {
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }

    public int officialSolution(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
