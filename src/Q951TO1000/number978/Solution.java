package Q951TO1000.number978;

/**
 * @author: Bright Chan
 * @date: 2021/2/8 10:59
 * @description: 滑动窗口
 */
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        boolean firstPattern = false, secondPattern = false;
        int left = 0, right = 1, len = arr.length;
        if (len < 2) return 1;

        int maxCount = 0;
        while (right < len) {
            if (arr[right - 1] < arr[right]) {
                if (!firstPattern && !secondPattern) {
                    if ((right & 1) == 1) firstPattern = true;
                    else secondPattern = true;
                    System.out.println("1");
                }
                else if (firstPattern && (right & 1) == 0) {
                    secondPattern = true;
                    firstPattern = false;
                    maxCount = Math.max(right - left, maxCount);
                    left = right - 1;
                    System.out.println("2");
                }
                else if (secondPattern && (right & 1) == 1) {
                    firstPattern = true;
                    secondPattern = false;
                    maxCount = Math.max(right - left, maxCount);
                    left = right - 1;
                    System.out.println("3");
                }
                System.out.println("a");
            }
            else if (arr[right - 1] > arr[right]) {
                if (!firstPattern && !secondPattern) {
                    if ((right & 1) == 0) firstPattern = true;
                    else secondPattern = true;
                    System.out.println("4");
                }
                else if (firstPattern && (right & 1) == 1) {
                    secondPattern = true;
                    firstPattern = false;
                    maxCount = Math.max(right - left, maxCount);
                    left = right - 1;
                    System.out.println("5");
                }
                else if (secondPattern && (right & 1) == 0) {
                    firstPattern = true;
                    secondPattern = false;
                    maxCount = Math.max(right - left, maxCount);
                    left = right - 1;
                    System.out.println("6");
                }
                System.out.println("a");
            }
            else {
                maxCount = Math.max(right - left, maxCount);
                left = right;
                firstPattern = secondPattern = false;
                System.out.println("7");
            }
            right++;
        }

        maxCount = Math.max(right - left, maxCount);
        return maxCount;
    }
}
