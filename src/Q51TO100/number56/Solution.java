package Q51TO100.number56;

/**
 * @author: Bright Chan
 * @date: 2020/9/2 10:33
 * @description: 排序
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return new int[][]{};
        int[][] store = new int[intervals.length][2];
        int tmp;
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    tmp = intervals[i][0];
                    intervals[i][0] = intervals[j][0];
                    intervals[j][0] = tmp;

                    tmp = intervals[i][1];
                    intervals[i][1] = intervals[j][1];
                    intervals[j][1] = tmp;
                }
            }
        }
        int max = intervals[0][0] - 1, pos = -1;

        for (int[] interval : intervals) {
            if (interval[0] > max) {
                pos++;
                store[pos][0] = interval[0];
                store[pos][1] = interval[1];
                max = interval[1];
            }
            else {
                max = Math.max(store[pos][1], interval[1]);
                store[pos][1] = max;
            }
        }

        int[][] res = new int[pos + 1][2];
        for (int i = 0; i < pos + 1; i++) {
            res[i][0] = store[i][0];
            res[i][1] = store[i][1];
        }
        return res;
    }
}
