package dataStructures.queue.getMedian;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author: Bright Chan
 * @date: 2021/2/3 13:05
 * @description: 得到数据流中的中位数
 */
public class MedianFinder {

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
    private static Comparator<Integer> comparator = (o1, o2) -> {
        if (o1 > o2) return -1;
        else if (o1.equals(o2)) return 0;
        else return 1;
    };

    public void addNum(int num) {
        size++;
        lowPart.offer(num);
        // 当一个新元素加入时，先放入lowPart，然后再将lowPart的最大值放入到highPart
        // 理由：如果新元素恰好是最大的，那么可能会比highPart中的某些元素还大，所以
        //       就得放入highPart中调整一下
        // 也可以先将lowPart的最大值和highPart的最小值比较一下再做决定
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
