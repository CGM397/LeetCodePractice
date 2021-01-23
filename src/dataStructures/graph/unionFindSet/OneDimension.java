package dataStructures.graph.unionFindSet;

/**
 * @author: Bright Chan
 * @date: 2021/1/21 11:54
 * @description: 并查集，一维点坐标
 */
public class OneDimension {

    /**
     * 构建并查集森林结构
     * @param nodeCount 点的个数，假设点是从1到N编号的，这样方便存储parent
     * @param edges 点之间的边集合
     * @return 每个点的父节点，根节点的父节点为自己
     */
    public int[] makeSet(int nodeCount, int[][] edges) {
        // 保存所有节点的父节点，开始时初始化为自己，parent[0]舍弃
        int[] parents = new int[nodeCount + 1];
        // 保存所有节点的秩，即节点的高度
        int[] ranks = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }

        // 根据边的关系，合并有关联的点
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            int parent1 = findParent(parents, node1);
            int parent2 = findParent(parents, node2);

            // 两个有关联的点还不在一个集合中，就将它们所在的集合合并
            if (parent1 != parent2) {
                union(parents, ranks, parent1, parent2);
            }
        }

        return parents;
    }

    // 按秩合并
    public void union(int[] parents, int[] ranks, int parent1, int parent2) {
        // parent1的高度比parent2的高度小，所以可以将parent1合并到parent2上，这样parent2
        // 的秩并不会变大
        if (ranks[parent1] < ranks[parent2]) {
            parents[parent1] = parent2;
        }
        else {
            parents[parent2] = parent1;

            // 如果两个节点的高度一样，则合并之后秩肯定会加一
            // 因为原本作为根节点的节点现在有了一个父节点
            if (ranks[parent1] == ranks[parent2]) {
                ranks[parent1]++;
            }
        }
    }

    // 路径压缩优化后的合并操作
    // 要记得，findParent方法不是找到直接父节点，而是根节点
    public int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }

    // 判断两个节点是否属于同一个集合
    public boolean inSameSet(int[] parents, int node1, int node2) {
        return findParent(parents, node1) == findParent(parents, node2);
    }

    // 得到集合数
    public int getSetNum(int[] parents) {
        int count = 0;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i) count++;
        }
        return count;
    }
}
