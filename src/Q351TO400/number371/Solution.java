package Q351TO400.number371;

/**
 * @author: Bright Chan
 * @date: 2021/9/26 9:43
 * @description: 数学
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
