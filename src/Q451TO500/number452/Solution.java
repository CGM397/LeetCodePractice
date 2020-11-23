package Q451TO500.number452;

/**
 * @author: Bright Chan
 * @date: 2020/11/23 10:16
 * @description: 排序+贪心
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len == 0) return 0;

        // sort
        for (int i = 0; i < len - 1; i++) {
            int[] cur = points[i];
            for (int j = i + 1; j < len; j++) {
                int[] next = points[j];
                if (cur[0] > next[0]) {
                    int tmp1 = cur[0], tmp2 = cur[1];

                    points[i][0] = next[0];
                    points[i][1] = next[1];
                    points[j][0] = tmp1;
                    points[j][1] = tmp2;
                }
                else if (cur[0] == next[0] && cur[1] > next[1]) {
                    int tmp1 = cur[0], tmp2 = cur[1];

                    points[i][0] = next[0];
                    points[i][1] = next[1];
                    points[j][0] = tmp1;
                    points[j][1] = tmp2;
                }
            }
        }
        for (int[] one : points) {
            System.out.println(one[0] + " " + one[1]);
        }

        int res = len;
        int tmp2 = points[0][1];
        for (int i = 1; i < len; i++) {
            int[] cur = points[i];
            if (cur[0] > tmp2) {
                tmp2 = cur[1];
            }
            else {
                tmp2 = Math.min(cur[1], tmp2);
                res--;
            }
        }
        return res;
    }
}
