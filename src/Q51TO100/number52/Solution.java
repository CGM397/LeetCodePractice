package Q51TO100.number52;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 11:01
 * @description: N皇后
 */
public class Solution {
    private List<Boolean> cols = new ArrayList<>();
    private Map<Integer, String> store = new HashMap<>();
    private int res = 0;

    public int totalNQueens(int n) {
        for (int i = 0; i < n; i++) {
            cols.add(false);
        }
        backTracking(0, n);
        return res;
    }

    private void backTracking(int pos, int n) {
        if (pos == n) {
            res++;
            return;
        }

        //第pos行
        for (int i = 0; i < n; i++) {
            if (!cols.get(i)) {
                int j = 0;
                for (; j < store.size(); j++) {
                    String[] tmp = store.get(j).split(";");
                    int row = Integer.parseInt(tmp[0]);
                    int col = Integer.parseInt(tmp[1]);
                    if (Math.abs(row - pos) == Math.abs(col - i)) break;
                }

                if (j == store.size()) {
                    cols.set(i, true);
                    store.put(pos, pos + ";" + i);
                    backTracking(pos + 1, n);
                    cols.set(i, false);
                    store.remove(pos);
                }
            }
        }
    }
}
