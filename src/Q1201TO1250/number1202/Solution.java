package Q1201TO1250.number1202;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/1/11 10:27
 * @description: 并查集
 */
public class Solution {

    // my solution
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] store = s.toCharArray();
        int len = s.length();
        int[] parents = new int[len];
        int[] ranks = new int[len];
        for (int i = 0; i < len; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }

        for (List<Integer> one : pairs) {
            int parent1 = findParent(parents, one.get(0));
            int parent2 = findParent(parents, one.get(1));

            if (parent1 != parent2) {
                union(parents, ranks, parent1, parent2);
            }
        }

        Map<Integer, List<Character>> storeChar = new HashMap<>();
        Map<Integer, List<Integer>> storeIndex = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int parent = findParent(parents, i);
            List<Character> chars = storeChar.getOrDefault(parent, new ArrayList<>());
            chars.add(store[i]);
            storeChar.put(parent, chars);

            List<Integer> indexs = storeIndex.getOrDefault(parent, new ArrayList<>());
            indexs.add(i);
            storeIndex.put(parent, indexs);
        }
        for (Integer index : storeChar.keySet()) {
            Collections.sort(storeChar.get(index));
        }

        char[] res = new char[len];

        for (Integer index : storeChar.keySet()) {
            List<Character> chars = storeChar.get(index);
            List<Integer> indexs = storeIndex.get(index);

            for (int i = 0; i < chars.size(); i++) {
                res[indexs.get(i)] = chars.get(i);
            }
        }
        return String.valueOf(res);
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

    // official solution
//    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//        if (pairs.size() == 0) {
//            return s;
//        }
//
//        // 第 1 步：将任意交换的结点对输入并查集
//        int len = s.length();
//        UnionFind unionFind = new UnionFind(len);
//        for (List<Integer> pair : pairs) {
//            int index1 = pair.get(0);
//            int index2 = pair.get(1);
//            unionFind.union(index1, index2);
//        }
//
//        // 第 2 步：构建映射关系
//        char[] charArray = s.toCharArray();
//        // key：连通分量的代表元，value：同一个连通分量的字符集合（保存在一个优先队列中）
//        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
//        for (int i = 0; i < len; i++) {
//            int root = unionFind.find(i);
//            if (hashMap.containsKey(root)) {
//                hashMap.get(root).offer(charArray[i]);
//            } else {
//                // PriorityQueue<Character> minHeap = new PriorityQueue<>();
//                // minHeap.offer(charArray[i]);
//                // hashMap.put(root, minHeap);
//                // 上面三行代码等价于下面一行代码，JDK 1.8 以及以后支持下面的写法
//                hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
//            }
//        }
//
//        // 第 3 步：重组字符串
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < len; i++) {
//            int root = unionFind.find(i);
//            stringBuilder.append(hashMap.get(root).poll());
//        }
//        return stringBuilder.toString();
//    }
//
//    private static class UnionFind {
//
//        private int[] parent;
//        /**
//         * 以 i 为根结点的子树的高度（引入了路径压缩以后该定义并不准确）
//         */
//        private int[] rank;
//
//        public UnionFind(int n) {
//            this.parent = new int[n];
//            this.rank = new int[n];
//            for (int i = 0; i < n; i++) {
//                this.parent[i] = i;
//                this.rank[i] = 1;
//            }
//        }
//
//        public void union(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            if (rootX == rootY) {
//                return;
//            }
//
//            if (rank[rootX] == rank[rootY]) {
//                parent[rootX] = rootY;
//                // 此时以 rootY 为根结点的树的高度仅加了 1
//                rank[rootY]++;
//            } else if (rank[rootX] < rank[rootY]) {
//                parent[rootX] = rootY;
//                // 此时以 rootY 为根结点的树的高度不变
//            } else {
//                // 同理，此时以 rootX 为根结点的树的高度不变
//                parent[rootY] = rootX;
//            }
//        }
//
//        public int find(int x) {
//            if (x != parent[x]) {
//                parent[x] = find(parent[x]);
//            }
//            return parent[x];
//        }
//    }
}
