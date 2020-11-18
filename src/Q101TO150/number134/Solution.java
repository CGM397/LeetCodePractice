package Q101TO150.number134;

/**
 * @author: Bright Chan
 * @date: 2020/11/18 9:05
 * @description: 数组
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, len = gas.length;
        while (start < len) {
            int i = start;
            int leftGas = 0;
            int count = 0;
            boolean flag = true;
            while (count < len) {
                if (i >= len) i = 0;

                leftGas += gas[i] - cost[i];
                if (leftGas < 0) {
                    flag = false;
                    break;
                }
                i++;
                count++;
            }
            if (flag) return start;
            start++;
        }
        return -1;
    }
}
