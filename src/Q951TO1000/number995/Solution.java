package Q951TO1000.number995;

/**
 * @author: Bright Chan
 * @date: 2021/2/18 11:08
 * @description: 差分数组
 */
public class Solution {
    public int mySlowMethod(int[] A, int K) {
        int left = 0, right = K, len = A.length, res = 0;

        while (right <= len) {
            if (A[left] == 0) {
                for (int i = left; i < right; i++) {
                    A[i] = A[i] ^ 1;
                }
                res++;
            }
            left++;
            right++;
        }
        for (int value : A) if (value == 0) return -1;

        return res;
    }

    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt ^= diff[i];
            if (A[i] == revCnt) { // A[i] ^ revCnt == 0
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                diff[i + K] ^= 1;
            }
        }
        return ans;
    }
}
