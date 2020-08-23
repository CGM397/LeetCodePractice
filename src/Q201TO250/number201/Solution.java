package Q201TO250.number201;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/8/23 10:20
 * @description: 按位与运算
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int[] store = new int[32];
        Arrays.fill(store, 1);
        store[0] = 0;
        int tmp;

        for (int i = 0; i < store.length; i++) {
            if (store[i] != 0) {
                tmp = (int) Math.pow(2, 31 - i);
                if (tmp > m) {
                    store[i] = 0;
                    if (tmp <= n) {
                        for (; i < store.length; i++) store[i] = 0;
                        break;
                    }
                    continue;
                }
                for (long j = m; j <= n; j++) {
                    if ((j >> 31 - i) % 2 == 0) {
                        store[i] = 0;
                        break;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i < store.length; i++) {
            res += Math.pow(2, 31 - i) * store[i];
        }
        return res;
    }

    //官方的解答，找到m和n对应的二进制码的公共前缀，后面的位直接补0
    public int fastRangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}
