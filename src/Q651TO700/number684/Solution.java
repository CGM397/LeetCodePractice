package Q651TO700.number684;

/**
 * @author: Bright Chan
 * @date: 2021/1/13 11:31
 * @description: 并查集
 */
public class Solution {

    // my solution
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parents = new int[len + 1];
        int[] ranks = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }

        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            int parent1 = find(parents, node1), parent2 = find(parents, node2);

            if (parent1 != parent2) {
                union(parents, ranks, parent1, parent2);
            }
            else {
                return edge;
            }
        }

        return new int[0];
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

    private int find(int[] parents, int node) {
        if (parents[node] != node) {
            parents[node] = find(parents, parents[node]);
        }
        return parents[node];
    }

    // official solution
//    public int[] findRedundantConnection(int[][] edges) {
//        int nodesCount = edges.length;
//        int[] parent = new int[nodesCount + 1];
//        for (int i = 1; i <= nodesCount; i++) {
//            parent[i] = i;
//        }
//        for (int[] edge : edges) {
//            int node1 = edge[0], node2 = edge[1];
//            if (find(parent, node1) != find(parent, node2)) {
//                union(parent, node1, node2);
//            } else {
//                return edge;
//            }
//        }
//        return new int[0];
//    }
//
//    public void union(int[] parent, int index1, int index2) {
//        parent[find(parent, index1)] = find(parent, index2);
//    }
//
//    public int find(int[] parent, int index) {
//        if (parent[index] != index) {
//            parent[index] = find(parent, parent[index]);
//        }
//        return parent[index];
//    }
}
