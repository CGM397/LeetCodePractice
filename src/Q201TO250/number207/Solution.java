package Q201TO250.number207;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/3/27 15:49
 * @description: 拓扑排序，广搜
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preNode = new int[numCourses];
        HashMap<Integer, List<Integer>> postNode = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            postNode.put(i, new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            preNode[edge[0]]++;
            List<Integer> tmp = postNode.get(edge[1]);
            tmp.add(edge[0]);
            postNode.put(edge[1], tmp);
        }

        Queue<Integer> nodes = new LinkedList<>();
        for (int i = 0; i < preNode.length; i++) {
            if (preNode[i] == 0) {
                nodes.offer(i);
            }
        }

        int count = 0;
        while (!nodes.isEmpty()) {
            int head = nodes.poll();
            count++;
            List<Integer> tmp = postNode.get(head);
            for (int i : tmp) {
                preNode[i]--;
                if (preNode[i] == 0) nodes.offer(i);
            }
        }
        return count == numCourses;
    }
}
