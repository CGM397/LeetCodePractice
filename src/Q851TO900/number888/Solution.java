package Q851TO900.number888;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/2/1 16:31
 * @description: 哈希表
 */
public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int targetSum = (sumA + sumB) / 2;

        if (sumA > sumB) {
            return exchange(B, A, targetSum, sumB, false);
        }
        else if (sumA < sumB) {
            return exchange(A, B, targetSum, sumA, true);
        }
        else {
            return new int[]{0, 0};
        }
    }

    private int[] exchange(int[] small, int[] big, int targetSum, int smallSum, boolean inOrder) {
        int bias = targetSum - smallSum;
        int index = 0;

        for (int cur : small) {
            int target = cur + bias;
            while (index < big.length && big[index] < target) index++;

            if (big[index] == target) {
                if (inOrder) return new int[]{cur, target};
                else return new int[]{target, cur};
            }
        }
        return new int[] {0, 0};
    }
}
