package Q951TO1000.number989;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/1/22 12:42
 * @description: 高精度
 */
public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int[] store = new int[10001];

        int count = store.length - 1, countA = A.length - 1, carry = 0;

        while (K > 0 &&countA >= 0) {
            int tmp = K % 10 + A[countA] + carry;
            store[count] = tmp % 10;
            carry = tmp / 10;

            K = K / 10;
            count--;
            countA--;
        }

        if (countA < 0) {
            while (K > 0) {
                int tmp = K % 10 + carry;
                store[count] = tmp % 10;
                carry = tmp / 10;

                K = K / 10;
                count--;
            }
        }

        if (K == 0) {
            while (countA >= 0) {
                int tmp = A[countA] + carry;
                store[count] = tmp % 10;
                carry = tmp / 10;

                count--;
                countA--;
            }
        }

        if (carry == 1) store[count] = 1;

        count = 0;
        while (count < store.length && store[count] == 0) count++;
        if (count == store.length) return Arrays.asList(0);

        List<Integer> res = new ArrayList<>();
        for (int i = count; i < store.length; i++) {
            res.add(store[i]);
        }
        return res;
    }
}
