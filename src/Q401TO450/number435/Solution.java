package Q401TO450.number435;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/12/31 10:58
 * @description: 贪心，动态规划
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] tmp = Arrays.copyOf(intervals[i], intervals[i].length);
                    intervals[i] = Arrays.copyOf(intervals[j], intervals[j].length);
                    intervals[j] = Arrays.copyOf(tmp, tmp.length);
                }
            }
        }

        for (int[] i : intervals) System.out.println(i[0] + " " + i[1]);
        int res = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] cur = intervals[i], next = intervals[i + 1];
            if (cur[1] > next[0]) {
                if (cur[1] > next[1]) {
                    intervals[i][1] = intervals[i][0];
                }
                else {
                    intervals[i + 1][1] = intervals[i][1];
                }
                res++;
            }
        }
        return res;
    }
}
