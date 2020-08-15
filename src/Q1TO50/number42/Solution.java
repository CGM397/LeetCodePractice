package Q1TO50.number42;

/**
 * @author: Bright Chan
 * @date: 2020/8/15 10:31
 * @description: 数组
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;

        int pos = 0, maxHeightIndex = 0, sum = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxHeightIndex])
                maxHeightIndex = i;
        }

        //需要去掉两边的0
        while (pos < height.length && height[pos] == 0) pos++;
        for (int i = pos + 1; i <= maxHeightIndex; i++) {
            if (height[i] >= height[pos]) {
                for (int j = pos + 1; j < i; j++) {
                    sum += height[pos] - height[j];
                }
                pos = i;
            }
        }

        pos = height.length -1;
        while (pos >= 0 && height[pos] == 0) pos--;
        for (int i = pos - 1; i >= maxHeightIndex; i--) {
            if (height[i] >= height[pos]) {
                for (int j = pos - 1; j > i; j--) {
                    sum += height[pos] - height[j];
                }
                pos = i;
            }
        }
        return sum;
    }
}
