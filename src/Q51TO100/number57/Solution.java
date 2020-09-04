package Q51TO100.number57;

/**
 * @author: Bright Chan
 * @date: 2020/9/3 22:53
 * @description: 排序
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] store = new int[intervals.length + 1][2];
        int count = 0;
        boolean flag = false;
        for (int[] interval : intervals) {
            if (!flag && newInterval[0] <= interval[0]) {
                store[count] = newInterval;
                count++;
                store[count] = interval;
                count++;
                flag = true;
                continue;
            }
            store[count] = interval;
            count++;
        }
        if (!flag) store[count] = newInterval;

        int max = store[0][0] - 1, pos = -1;
        int[][] tmp = new int[intervals.length + 1][2];
        for (int[] interval : store) {
            if (interval[0] > max) {
                pos++;
                tmp[pos][0] = interval[0];
                tmp[pos][1] = interval[1];
                max = interval[1];
            }
            else {
                max = Math.max(tmp[pos][1], interval[1]);
                tmp[pos][1] = max;
            }
        }

        int[][] res = new int[pos + 1][2];
        for (int i = 0; i < pos + 1; i++) {
            res[i][0] = tmp[i][0];
            res[i][1] = tmp[i][1];
        }
        return res;
    }
}
