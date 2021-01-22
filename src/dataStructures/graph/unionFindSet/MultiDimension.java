package dataStructures.graph.unionFindSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/1/21 20:19
 * @description: 并查集，多维点坐标
 */
public class MultiDimension {

    public List<Node> makeSet(int[][] stones) {
        List<Node> parents = new ArrayList<>(stones.length);
        for (int[] stone : stones) {
            parents.add(new Node(null, stone[0], stone[1], 0));
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int[] cur = stones[i];
            for (int j = i + 1; j < stones.length; j++) {
                int[] next = stones[j];
                if (cur[0] == next[0] || cur[1] == next[1]) {
                    Node parent1 = findParent(parents.get(i));
                    Node parent2 = findParent(parents.get(j));
                    if (parent1 != parent2) {
                        union(parent1, parent2);
                    }
                }
            }
        }
        
        return parents;
    }

    public static class Node {
        public Node parent;

        public int x;

        public int y;

        public int rank;

        public Node (Node node, int x, int y, int rank) {
            this.parent = node;
            this.x = x;
            this.y = y;
            this.rank = rank;
        }
    }

    public void union(Node parent1, Node parent2) {

        if (parent1.rank > parent2.rank) {
            parent2.parent = parent1;
        }
        else {
            parent1.parent = parent2;

            if (parent1.rank == parent2.rank) {
                parent2.rank++;
            }
        }
    }

    // 这里和处理一维数组时的方式不太一样，因为根节点的父节点不是自己，而是null
    public Node findParent(Node node) {
        if (node.parent != null) {
            if (node.parent.parent != null) {
                node.parent = findParent(node.parent);
            }
            return node.parent;
        }
        else {
            return node;
        }
    }

    public boolean inSameSet(Node node1, Node node2) {
        return node1.parent == node2.parent;
    }

    public int getSetNum(List<Node> parents) {
        int count = 0;
        for (Node one : parents) {
            if (one.parent == null) count++;
        }
        return count;
    }
}
