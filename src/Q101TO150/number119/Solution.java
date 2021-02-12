package Q101TO150.number119;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/2/12 10:27
 * @description: 杨辉三角
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] first = new Integer[] {1};
        while (rowIndex > 0) {
            first = getNextRow(first);
            rowIndex--;
        }
        return Arrays.asList(first);
    }

    private Integer[] getNextRow(Integer[] row) {
        int len = row.length;
        Integer[] res = new Integer[len + 1];
        res[0] = res[len] = 1;

        for (int i = 1; i < len; i++) {
            res[i] = row[i - 1] + row[i];
        }

        return res;
    }
}
