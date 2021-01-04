package Q501TO550.number509;

/**
 * @author: Bright Chan
 * @date: 2021/1/4 11:05
 * @description: 斐波那契数列
 */
public class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        n = n - 1;
        int a = 1, b = 0, tmp;
        while (n > 0) {
            tmp = a;
            a = a + b;
            b = tmp;
            n--;
        }
        return a;
    }
}
