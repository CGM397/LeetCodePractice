package Q1301TO1350.number1337;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/8/1 16:35
 * @description: 排序；二分查找
 */
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> store = new ArrayList<>();
        boolean[] visited = new boolean[mat.length];
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (!visited[i] && mat[i][j] == 0) {
                    store.add(i);
                    visited[i] = true;
                    if (store.size() == k) {
                        break;
                    }
                }
            }
            if (store.size() == k) {
                break;
            }
        }

        int tmp = store.size();
        if (tmp < k) {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    store.add(i);
                    tmp++;
                    if (tmp == k) {
                        break;
                    }
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = store.get(i);
        }

        return res;
    }
}
