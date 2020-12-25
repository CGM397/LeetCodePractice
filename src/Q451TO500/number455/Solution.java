package Q451TO500.number455;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/12/25 10:04
 * @description: 数组
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i, j = 0, res = 0;

        for (i = 0; i < g.length; i++) {

            while (j < s.length && g[i] > s[j]) j++;

            if (j == s.length) break;

            res++;
            j++;
        }
        return res;
    }
}
