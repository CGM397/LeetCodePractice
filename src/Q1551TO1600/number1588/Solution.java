package Q1551TO1600.number1588;

/**
 * @author: Bright Chan
 * @date: 2021/8/29 14:34
 * @description: 数学
 */
public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int rightCount = n - i - 1;
            int leftOdd = (i + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = i / 2 + 1;
            int rightEven = rightCount / 2 + 1;
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }
}
