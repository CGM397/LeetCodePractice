package Q451TO500.number480;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author: Bright Chan
 * @date: 2021/2/3 9:52
 * @description: 优先队列
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianFinder finder = new MedianFinder();
        int left = 0, right = k - 1;
        for (int i = 0; i < k; i++) {
            finder.addNum(nums[i]);
        }

        int len = nums.length;
        double[] res = new double[len - k + 1];
        int count = 0;
        while (right < len) {
            res[count] = finder.findMedian();
            count++;

            finder.removeNum(nums[left]);
            left++;
            right++;
            if (right == len) break;
            finder.addNum(nums[right]);
        }
        return res;
    }

    public static class MedianFinder {

        // 存数据流的前半部分，最大堆
        private PriorityQueue<Integer> lowPart;

        // 存数据流的后半部分，最小堆
        private PriorityQueue<Integer> highPart;

        // 整体的size: lowPart.size() + highPart.size()
        int size;

        public MedianFinder() {
            lowPart = new PriorityQueue<>(comparator);
            highPart = new PriorityQueue<>();
            size = 0;
        }

        // 不能简单写成 (x, y) -> y - x;
        // 因为可能会导致整型溢出
        // 也可以写成compareTo
        private static Comparator<Integer> comparator = Comparator.reverseOrder();

        public void addNum(int num) {
            size++;
            lowPart.offer(num);
            // 当一个新元素加入时，先放入lowPart，然后再将lowPart的最大值放入到highPart
            // 理由：如果新元素恰好是最大的，那么可能会比highPart中的某些元素还大，所以
            //       就得放入highPart中调整一下
            highPart.offer(Objects.requireNonNull(lowPart.poll()));

            // 当总个数为奇数时，lowPart比highPart多一个元素
            // 因为上面调整过，所以将highPart中的最小值放入lowPart中是可以的
            if((size & 1) == 1) {
                lowPart.offer(Objects.requireNonNull(highPart.poll()));
            }
        }

        public void removeNum(int num) {
            if (lowPart.remove(num)) {
                // 调整前后两部分的大小
                if (lowPart.size() < highPart.size()) {
                    lowPart.offer(highPart.poll());
                }
            }
            else if (highPart.remove(num)) {
                // 调整前后两部分的大小
                if (lowPart.size() > highPart.size() + 1) {
                    highPart.offer(Objects.requireNonNull(lowPart.poll()));
                }
            }

            size--;
        }

        public double findMedian() {
            if (lowPart.isEmpty()) return 0;

            if ((size & 1) == 1) {
                return (double) lowPart.peek();
            }
            else {
                // 这种情况不会出现，即总个数为偶数，但是highPart却为0
                // 此处是为了消除下一行的warning
                if (highPart.isEmpty()) return 0;
                // 防止整型溢出
                double low = lowPart.peek();
                double high = highPart.peek();
                return (high + low) / 2.0;
            }
        }
    }
}
