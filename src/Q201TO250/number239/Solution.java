package Q201TO250.number239;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: Bright Chan
 * @date: 2021/1/2 10:31
 * @description: 优先队列，单调队列
 */
public class Solution {

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public int[] mySlowMethod(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int maxValue = getMaxValue(nums, 0, k), count = 0;
        res[count] = maxValue;

        for (int i = 1; i < len - k + 1; i++) {
            count++;
            int end = i + k;
            if (nums[i - 1] < maxValue) {
                if (nums[end - 1] < maxValue) res[count] = maxValue;
                else {
                    res[count] = nums[end - 1];
                    maxValue = nums[end - 1];
                }
            }
            else {
                if (nums[end - 1] >= maxValue) {
                    res[count] = nums[end - 1];
                    maxValue = nums[end - 1];
                }
                else {
                    maxValue = getMaxValue(nums, i, end);
                    res[count] = maxValue;
                }
            }
        }

        return res;
    }

    private int getMaxValue(int[] nums, int start, int end) {
        int maxValue = nums[start];
        for (int i = start; i < end; i++) {
            if (nums[i] > maxValue) maxValue = nums[i];
        }
        return maxValue;
    }
}
