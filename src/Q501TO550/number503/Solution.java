package Q501TO550.number503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Bright Chan
 * @date: 2021/3/6 10:43
 * @description: 单调栈
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}
