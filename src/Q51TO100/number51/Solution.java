package Q51TO100.number51;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2020/8/24 17:55
 * @description: N皇后
 */
public class Solution {

    private List<Boolean> cols = new ArrayList<>();
    private Map<Integer, String> store = new HashMap<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n; i++) {
            cols.add(false);
        }
        backTracking(0, n);
        return res;
    }

    private void backTracking(int pos, int n) {
        if (pos == n) {
            List<String> one = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] oneRow = new char[n];
                Arrays.fill(oneRow, '.');
                String[] tmp = store.get(i).split(";");
                int col = Integer.parseInt(tmp[1]);
                oneRow[col] = 'Q';
                one.add(new String(oneRow));
            }
            res.add(one);
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
