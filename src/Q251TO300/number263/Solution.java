package Q251TO300.number263;

/**
 * @author: Bright Chan
 * @date: 2021/4/10 12:40
 * @description: 数学
 */
public class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }
}
