package Q701TO750.number703;

import java.util.PriorityQueue;

/**
 * @author: Bright Chan
 * @date: 2021/2/11 11:39
 * @description: 优先队列；取前k个元素，可以设置优先队列的容量为k
 */
public class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
