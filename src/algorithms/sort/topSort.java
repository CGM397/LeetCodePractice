package algorithms.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Bright Chan
 * @date: 2021/3/17 21:36
 * @description: 拓扑排序
 */
public class topSort {

    public int[] topSort(int num, int[][] edges) {
        List<List<Integer>> store = new ArrayList<>();
        int[] inDegree = new int[num];

        for (int i = 0; i < num; i++) store.add(new ArrayList<>());
        for (int[] edge : edges) {
            store.get(edge[1]).add(edge[0]);
            inDegree[edge[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int[] res = new int[num];
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[count] = cur;
            count++;

            List<Integer> node = store.get(cur);
            for (int v : node) {
                inDegree[v] -= 1;
                if (inDegree[v] == 0) queue.offer(v);
            }
        }
        return count == num ? res : new int[0];
    }
}
