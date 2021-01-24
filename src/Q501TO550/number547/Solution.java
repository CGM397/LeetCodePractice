package Q501TO550.number547;

/**
 * @author: Bright Chan
 * @date: 2021/1/7 11:16
 * @description: 图，dfs
 */
public class Solution {

    // union-find set solution
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] parents = new int[len];
        int[] ranks = new int[len];
        for (int i = 0; i < len; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isConnected[i][j] == 0) continue;

                int parent1 = findParent(parents, i);
                int parent2 = findParent(parents, j);
                if (parent1 != parent2) {
                    union(parents, ranks, parent1, parent2);
                }
            }
        }
        return getSetNum(parents);
    }

    // 按秩合并
    private void union(int[] parents, int[] ranks, int parent1, int parent2) {
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
    private int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }

    // 得到集合数
    private int getSetNum(int[] parents) {
        int count = 0;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i) count++;
        }
        return count;
    }

    // dfs solution
//    public int findCircleNum(int[][] isConnected) {
//        int len = isConnected.length;
//        boolean[] flag = new boolean[len];
//        Arrays.fill(flag, false);
//
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            if (!flag[i]) {
//                dfs(i, isConnected, flag);
//                res++;
//            }
//        }
//
//        return res;
//    }
//
//    private void dfs (int i, int[][] isConnected, boolean[] flag) {
//        flag[i] = true;
//
//        for (int j = 0; j < isConnected.length; j++) {
//            if (!flag[j] && isConnected[i][j] == 1) {
//                dfs(j, isConnected, flag);
//            }
//        }
//    }
}
