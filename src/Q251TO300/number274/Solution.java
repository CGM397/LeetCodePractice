package Q251TO300.number274;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/7/12 20:58
 * @description: 排序
 */
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int len = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (len - i <= citations[i]) {
                return len - i;
            }
        }

        return 0;
    }
}
