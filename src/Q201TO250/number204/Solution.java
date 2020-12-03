package Q201TO250.number204;

/**
 * @author: Bright Chan
 * @date: 2020/12/3 10:29
 * @description: 质数；埃氏筛；线性筛
 */
public class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;

        int res = 0;
        for (int i = 2; i < n; i++) {
            int tmp = (int) Math.sqrt(i);
            boolean flag = true;
            for (int j = 2; j <= tmp; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) res++;
        }
        return res;
    }
}
