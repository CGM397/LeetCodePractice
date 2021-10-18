package microsoft.number06;

import java.util.PriorityQueue;

/**
 * @author: Bright Chan
 * @date: 2021/10/16 12:54
 * @description: TODO
 */
public class Solution {
    public int solution(int[] A) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i : A){
            priorityQueue.offer(i);
        }
        int total = 0;
        while (priorityQueue.size() > 1){
            int x = priorityQueue.poll() + priorityQueue.poll();
            total += x;
            priorityQueue.offer(x);
        }
        return total;
    }
}
