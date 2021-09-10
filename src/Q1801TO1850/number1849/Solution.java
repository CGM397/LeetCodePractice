package Q1801TO1850.number1849;

/**
 * @author: Bright Chan
 * @date: 2021/9/10 18:35
 * @description: 模拟
 */
public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long total = 0;
        for (int num : chalk) {
            total += num;
        }
        k %= total;
        int res = -1;
        for (int i = 0; i < n; ++i) {
            if (chalk[i] > k) {
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }
}
