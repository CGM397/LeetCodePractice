package Q1401TO1450.number1438;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Bright Chan
 * @date: 2021/2/21 10:52
 * @description: 滑动窗口 + 单调队列
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> up = new LinkedList<>();
        Deque<Integer> down = new LinkedList<>();

        int left = 0, right = 1, len = nums.length, min, max;
        up.offer(nums[0]);
        down.offer(nums[0]);
        while (right < len) {
            int cur = nums[right];
            insertUp(up, cur);
            insertDown(down, cur);
            min = up.getFirst();
            max = down.getFirst();
            if (max - min > limit) {
                if (nums[left] == max) down.removeFirst();
                if (nums[left] == min) up.removeFirst();
                left++;
            }
            right++;
        }
        return right - left;
    }

    private void insertUp(Deque<Integer> up, int cur) {
        while (!up.isEmpty() && up.getLast() > cur) {
            up.removeLast();
        }
        up.offer(cur);
    }

    private void insertDown(Deque<Integer> down, int cur) {
        while (!down.isEmpty() && down.getLast() < cur) {
            down.removeLast();
        }
        down.offer(cur);
    }
}
