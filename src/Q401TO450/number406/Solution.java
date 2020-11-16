package Q401TO450.number406;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/11/16 10:33
 * @description: 排序
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // sort
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = i + 1; j < people.length; j++) {
                int cur = people[i][0];
                int next = people[j][0];
                if (cur > next) {
                    int[] tmp = people[i];
                    people[i] = people[j];
                    people[j] = tmp;
                }
            }
        }

        int[][] res = new int[people.length][2];
        for (int[] i : res) Arrays.fill(i, -1);
        for (int[] one : people) {
            int num = one[0];
            int index = one[1];

            int count = 0, i = 0;
            for (; i < res.length; i++) {
                if (count == index) break;
                int[] tmp = res[i];
                if (tmp[0] == -1 || tmp[0] >= num) count++;
            }
            while (res[i][0] > -1) i++;
            res[i][0] = num;
            res[i][1] = index;
        }

        return res;
    }
}
