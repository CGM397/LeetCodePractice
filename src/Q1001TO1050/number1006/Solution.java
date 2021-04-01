package Q1001TO1050.number1006;

/**
 * @author: Bright Chan
 * @date: 2021/4/1 15:55
 * @description: 模拟
 */
public class Solution {
    public int clumsy(int N) {
        int res = N;
        char op = '*';
        for (int i = N - 1; i >= 1; i--) {
            if (op == '*') {
                res *= i;
                op = '/';
            }
            else if (op == '/') {
                res /= i;
                op = '+';
            }
            else if (op == '+') {
                res += i;
                op = '-';
            }
            else {
                if (i > 2) {
                    res -= i * (i - 1) / (i - 2);
                    i -= 2;
                    op = '+';
                }
                else if (i > 1) {
                    res -= i * (i - 1);
                    break;
                }
                else {
                    res -= i;
                }
            }
        }
        return res;
    }
}
