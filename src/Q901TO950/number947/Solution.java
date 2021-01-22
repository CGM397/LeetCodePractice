package Q901TO950.number947;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/1/15 13:38
 * @description: 并查集
 */
public class Solution {

    public int removeStones(int[][] stones) {

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
        return stones.length - getSetNum(parents);
    }

    private static class Node {
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

    private void union(Node parent1, Node parent2) {

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

    private Node findParent(Node node) {
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

    private int getSetNum(List<Node> parents) {
        int count = 0;
        for (Node one : parents) {
            if (one.parent == null) count++;
        }
        return count;
    }

    // official solution
//    public int removeStones(int[][] stones) {
//        UnionFind unionFind = new UnionFind();
//
//        for (int[] stone : stones) {
//            // 下面这三种写法任选其一
//            // unionFind.union(~stone[0], stone[1]);
//            // unionFind.union(stone[0] - 10001, stone[1]);
//            unionFind.union(stone[0] + 10001, stone[1]);
//        }
//        return stones.length - unionFind.getCount();
//    }
//
//    private class UnionFind {
//
//        private Map<Integer, Integer> parent;
//        private int count;
//
//        public UnionFind() {
//            this.parent = new HashMap<>();
//            this.count = 0;
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public int find(int x) {
//            if (!parent.containsKey(x)) {
//                parent.put(x, x);
//                // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
//                count++;
//            }
//
//            if (x != parent.get(x)) {
//                parent.put(x, find(parent.get(x)));
//            }
//            return parent.get(x);
//        }
//
//        public void union(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            if (rootX == rootY) {
//                return;
//            }
//
//            parent.put(rootX, rootY);
//            // 两个连通分量合并成为一个，连通分量的总数 -1
//            count--;
//        }
//    }
}
