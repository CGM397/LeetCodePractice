package Q1351TO1400.number1356;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: Bright Chan
 * @date: 2020/11/6 20:22
 * @description: 排序
 */
public class Solution {
    public int[] sortByBits(int[] arr) {
        List<PriorityQueue<Integer>> store = new ArrayList<>(32);
        for (int i = 0; i < 32; i++) {
            store.add(new PriorityQueue<>());
        }

        for(int i : arr) {
            int count = 0, originNum = i;
            while (i > 0) {
                count += i % 2;
                i = i / 2;
            }
            PriorityQueue<Integer> tmp = store.get(count);
            tmp.add(originNum);
            store.set(count, tmp);
        }

        int[] res = new int[arr.length];
        int count = 0;
        for (PriorityQueue<Integer> one : store) {
            while (count < arr.length && !one.isEmpty()) {
                res[count] = one.poll();
                count++;
            }
        }

        return res;
    }
}
