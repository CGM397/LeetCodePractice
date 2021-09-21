package microsoft.number02;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2021/9/20 19:13
 * @description: 主要逻辑：先排序，然后尝试对最大的元素使用方案二，然后多出来的能量去覆盖尽可能多的用户；
 *               如果用方案二花费的钱所覆盖的用户，全都去使用方案一的话，花费的钱比前者少，那就说明剩下的
 *               所有用户都只需要去使用方案一即可
 */
public class Solution {
    public int solution(int[] A, int X, int Y) {
        Arrays.sort(A);
        int left = 0, right = A.length - 1;
        int res = 0;
        while (left < right) {
            // planeB
            int extraEnergy = A[right];
            int preIndex = left;

            while (A[left] <= extraEnergy) {
                extraEnergy -= A[left];
                left++;
            }

            // planeA
            int planeA = X * (left - preIndex + 1);

            if (planeA > Y) {
                res += Y;
                right--;
            }
            else {
                left = preIndex;
                break;
            }
        }

        if (right == left) {
            res += Math.min(X, Y);
        }
        else {
            res += X * (right - left + 1);
        }

        return res;
    }
}
