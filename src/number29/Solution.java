package number29;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:53
 * @description: 位运算
 */
public class Solution {
    public int failedMethod(int dividend, int divisor) {
        long res = 0;
        long absDividend = dividend;
        absDividend = absDividend > 0 ? absDividend : -absDividend;
        long absDivisor = divisor;
        absDivisor = absDivisor > 0 ? absDivisor : -absDivisor;

        boolean negativeFlag = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            negativeFlag = true;
        }
        //divide，当被除数很大，除数很小的时候，运行时间过长
        while(absDividend >= absDivisor) {
            absDividend -= absDivisor;
            res++;
        }
        res = negativeFlag ? -res : res;
        res = (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? Integer.MAX_VALUE : res;
        return (int)res;
    }

    public int divide(int dividend, int divisor) {
        long res = 0;
        long absDividend = dividend;
        absDividend = absDividend > 0 ? absDividend : -absDividend;
        long absDivisor = divisor;
        absDivisor = absDivisor > 0 ? absDivisor : -absDivisor;

        //异或操作得到两数的符号是否相异
        boolean negativeFlag = (dividend ^ divisor) < 0;

        for (int i = 31; i >= 0; i--) {
            //被除数除以2^i，若不小于除数，则说明2^i * absDivisor <= absDividend
            //则被除数减去2^i * absDivisor，结果加上2^i
            //注意：1 << 31：32位有符号整数溢出，所以需要1L << 31
            if ((absDividend >> i) >= absDivisor) {
                res += 1L << i;
                absDividend -= absDivisor << i;
            }
        }
        res = negativeFlag ? -res : res;
        res = (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? Integer.MAX_VALUE : res;
        return (int) res;
    }
}
