package Q301TO350.number326;

/**
 * @author: Bright Chan
 * @date: 2021/9/23 22:06
 * @description: 数学
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
