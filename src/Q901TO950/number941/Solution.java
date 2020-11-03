package Q901TO950.number941;

/**
 * @author: Bright Chan
 * @date: 2020/11/3 10:23
 * @description: 数组
 */
public class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;

        boolean peak = false;
        int i = 1;
        for (; i < A.length; i++) {
            int cur = A[i], pre = A[i - 1];
            if (!peak) {
                if (cur == pre) break;
                else if (cur < pre) {
                    if (i == 1) break;
                    else peak = true;
                }
            }
            else {
                if (cur >= pre) break;
            }
        }
        return i == A.length && peak;
    }
}
