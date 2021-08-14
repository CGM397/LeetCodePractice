package Q1551TO1600.number1583;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/8/14 10:47
 * @description: 哈希表
 */
public class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int[] pair : pairs) {
            store.put(pair[0], pair[1]);
            store.put(pair[1], pair[0]);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            int x = entry.getKey(), y = entry.getValue();

            int[] preference = preferences[x];
            for (int one : preference) {
                if (one == y) break;

                if (loveMeMore(x, one, preferences, store)) {
                    res += 1;
                    break;
                }
            }
        }
        return res;
    }

    private boolean loveMeMore(int x, int u, int[][] preferences, Map<Integer, Integer> store) {
        int[] preference = preferences[u];
        int v = store.get(u);
        boolean visitedV = false;

        for (int one : preference) {
            if (one == x) {
                return !visitedV;
            }
            else if (one == v) {
                visitedV = true;
            }
        }
        return false;
    }
}
