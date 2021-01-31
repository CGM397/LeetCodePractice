package Q801TO850.number839;

/**
 * @author: Bright Chan
 * @date: 2021/1/31 9:46
 * @description: 并查集
 */
public class Solution {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        int strLen = strs[0].length();

        int[] parents = new int[len];
        int[] ranks = new int[len];
        for (int i = 0; i < len; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // i 的findParent不能写在这一层循环的外面，因为每一次union的时候可能会导致i的parent发生变化
                int parent1 = findParent(parents, i);
                int parent2 = findParent(parents, j);
                if (parent1 != parent2 && isSimilar(strLen, strs[i], strs[j])) {
                    union(parents, ranks, parent1, parent2);
                }
            }
        }

        return getSetNum(parents);
    }

    private void union(int[] parents, int[] ranks, int parent1, int parent2) {
        if (ranks[parent1] < ranks[parent2]) {
            parents[parent1] = parent2;
        }
        else {
            parents[parent2] = parent1;

            if (ranks[parent1] == ranks[parent2]) {
                ranks[parent1]++;
            }
        }
    }

    private int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }

    private int getSetNum(int[] parents) {
        int count = 0;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i) count++;
        }
        return count;
    }

    private boolean isSimilar(int len, String str1, String str2) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
                if (count > 2) return false;
            }
        }
        return true;
    }
}
