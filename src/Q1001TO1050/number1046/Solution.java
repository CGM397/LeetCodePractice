package Q1001TO1050.number1046;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Bright Chan
 * @date: 2020/12/30 11:09
 * @description: 最大堆，优先队列
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> store = new PriorityQueue<>(cmp);

        for (int i : stones) store.add(i);

        while (store.size() > 1) {
            int a = store.poll(), b = store.poll();
            if (a - b > 0) store.add(a - b);
        }
        return store.isEmpty() ? 0 : store.poll();
    }

    // return 负数 表示第一个参数应该排在第二个参数之前；
    // return 正数 表示第一个参数应该排在第二个参数之后；
    // return 零   表示两数相等。
    private static Comparator<Integer> cmp = (e1, e2) -> e2 - e1;
}
