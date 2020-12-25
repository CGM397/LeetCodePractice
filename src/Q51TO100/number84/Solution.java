package Q51TO100.number84;

import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/11/5 11:57
 * @description: 单调栈
 */
public class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            // -1表示左边没有比heights[i]低的元素
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            // n表示右边没有比heights[i]低的元素
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    // 遍历数组，以每一个遍历到的元素作为最低点，向其左右发散，找到以其作为最低点的最大的矩形
    public int mySlowMethod(int[] heights) {
        if (heights.length < 1) return 0;

        int len = heights.length, maxArea = 0;
        for (int i = 0; i < len; i++) {
            int left = i - 1, right = i + 1, cur = heights[i], curArea = cur;
            while (left >= 0 && heights[left] >= cur) {
                curArea += cur;
                left--;
            }
            while (right < len && heights[right] >= cur) {
                curArea += cur;
                right++;
            }

            if (maxArea < curArea) maxArea = curArea;
        }

        return maxArea;
    }
}
