package dataStructures.graph.unionFindSet;

/**
 * @author: Bright Chan
 * @date: 2021/1/26 10:50
 * @description: 一维数组；类模式
 */
public class UnionFind {
    private int[] parent;
    private int[] ranks;

    public UnionFind(int n) {
        parent = new int[n];
        ranks = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            ranks[i] = 0;
        }
    }

    public void union(int index1, int index2) {
        int parent1 = find(index1);
        int parent2 = find(index2);
        if (ranks[parent1] < ranks[parent2]) {
            parent[parent1] = parent2;
        }
        else {
            parent[parent2] = parent1;

            if (ranks[parent1] == ranks[parent2]) {
                ranks[parent1]++;
            }
        }
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
