package microsoft.number05;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/10/16 12:54
 * @description: TODO
 */
public class Solution {
    public int solution(int N, int[] A, int[] B) {
        int[] edgeCount = new int[N + 1];
        for (int i = 0; i < A.length; i++) {
            edgeCount[A[i]]++;
            edgeCount[B[i]]++;
        }
        Map<Integer, List<Integer>> edgeSort = new TreeMap<>();
        for (int i = 1; i <= N; i++) {
            List<Integer> tmp = edgeSort.getOrDefault(edgeCount[i], new ArrayList<>());
            tmp.add(i);
            edgeSort.put(edgeCount[i], tmp);
        }

        // more edges the vertex has, greater weight we assign
        int[] weightAssign = new int[N + 1];
        int leftMaxNum = 1;
        for (Map.Entry<Integer, List<Integer>> entry : edgeSort.entrySet()) {
            List<Integer> one = entry.getValue();
            for (int i : one) {
                weightAssign[i] = leftMaxNum;
                leftMaxNum++;
            }
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += weightAssign[A[i]] + weightAssign[B[i]];
        }

        return sum;
    }
}
