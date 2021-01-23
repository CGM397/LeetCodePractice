package Q1301TO1350.number1319;

/**
 * @author: Bright Chan
 * @date: 2021/1/23 10:33
 * @description: 并查集
 */
public class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        int[] parents = new int[n];
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }

        for (int[] connection : connections) {
            int node1 = connection[0], node2 = connection[1];
            int parent1 = findParent(parents, node1), parent2 = findParent(parents, node2);

            if (parent1 != parent2) {
                union(parents, ranks, parent1, parent2);
            }
        }
        int setNum = getSetNum(parents);

        return setNum - 1;
    }

    private void union(int[] parents, int[] ranks, int parent1, int parent2) {
        if (ranks[parent1] > ranks[parent2]) {
            parents[parent2] = parent1;
        }
        else {
            parents[parent1] = parent2;

            if (ranks[parent1] == ranks[parent2]) {
                ranks[parent2]++;
            }
        }
    }

    private int findParent(int[] parents, int node) {
        if (parents[node] != node) {
            parents[node] = findParent(parents, parents[node]);
        }
        return parents[node];
    }

    private int getSetNum(int[] parents) {
        int count = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i) count++;
        }
        return count;
    }
}
