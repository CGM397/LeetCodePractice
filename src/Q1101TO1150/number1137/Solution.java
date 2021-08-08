package Q1101TO1150.number1137;

/**
 * @author: Bright Chan
 * @date: 2021/8/8 11:40
 * @description: 动态规划
 */
public class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;

        int t0 = 0, t1 = 1, t2 = 1, tmp;

        while (n >= 3) {
            tmp = t2;
            t2 += t0 + t1;
            t0 = t1;
            t1 = tmp;
            n--;
        }
        return t2;
    }
}
