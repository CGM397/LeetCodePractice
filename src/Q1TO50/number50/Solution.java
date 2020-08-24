package Q1TO50.number50;

/**
 * @author: Bright Chan
 * @date: 2020/8/24 15:33
 * @description: 快速幂
 */
public class Solution {
    public double myPow(double x, int n) {
        long m = n;
        // 必须换成long再取绝对值
        m = m > 0 ? m : -m;
        double res = quickPow(x, m);
        return n >= 0 ? res : 1 / res;
    }

    private double quickPow(double x, long n) {
        if (n == 0) return 1;
        else if (n % 2 == 1) return quickPow(x, n - 1) * x;
        else {
            // 这一步计算出tmp是必要的，因为如果直接写成
            // return myPow(x, n / 2) * myPow(x, n / 2)的话，会计算两次，
            // 从而时间复杂度退化成了O(n)
            double tmp = quickPow(x, n / 2);
            return tmp * tmp;
        }
    }
}
