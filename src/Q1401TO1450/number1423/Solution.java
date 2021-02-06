package Q1401TO1450.number1423;

/**
 * @author: Bright Chan
 * @date: 2021/2/6 12:01
 * @description: 滑动窗口
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = k - 1, right = cardPoints.length;
        int res = 0;
        for (int i = 0; i <= left; i++) {
            res += cardPoints[i];
        }

        int tmp = res;
        while (left >= 0) {
            tmp -= cardPoints[left];
            left--;
            right--;
            tmp += cardPoints[right];

            if (tmp > res) res = tmp;
        }
        return res;
    }
}
