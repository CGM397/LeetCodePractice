package Q851TO900.number896;

/**
 * @author: Bright Chan
 * @date: 2021/2/28 16:56
 * @description: 数组
 */
public class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 1) return true;
        int len = A.length;
        boolean up = false, down = false;

        for (int i = 0; i < len - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (!up && !down) up = true;
                else if (down) return false;
            }
            else if (A[i] > A[i + 1]) {
                if (!up && !down) down = true;
                else if (up) return false;
            }
        }
        return true;
    }
}
