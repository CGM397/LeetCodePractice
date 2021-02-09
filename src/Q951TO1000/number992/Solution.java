package Q951TO1000.number992;

/**
 * @author: Bright Chan
 * @date: 2021/2/9 10:26
 * @description: 滑动窗口
 */
public class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        // 最多包含K个元素的子区间的个数减去最多包含K-1个元素的子区间的个数
        // 正好等于：恰好包含K个元素的子区间的个数，即为所求
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    /**
     * @param A 数组
     * @param K K
     * @return 最多包含 K 个不同整数的子区间的个数
     */
    private int atMostKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];

        int left = 0;
        int right = 0;
        // [left, right) 里不同整数的个数
        int count = 0;
        int res = 0;
        // [left, right) 包含不同整数的个数小于等于 K
        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            // [left, right) 区间的长度就是对结果的贡献
            res += right - left;
        }
        return res;
    }
}
