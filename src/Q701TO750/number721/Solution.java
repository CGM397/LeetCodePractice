package Q701TO750.number721;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/1/19 15:52
 * @description: 并查集
 */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> storeName = new HashMap<>();
        Map<String, Integer> storeId = new HashMap<>();

        int count = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!storeName.containsKey(email)) {
                    storeName.put(email, name);
                    storeId.put(email, count);
                    count++;
                }
            }
        }

        int[] parents = new int[count];
        int[] ranks = new int[count];
        for (int i = 0; i < count; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }

        for (List<String> account : accounts) {
            String cur = account.get(1);
            for (int j = 2; j < account.size(); j++) {
                String next = account.get(j);
                int parent1 = findParent(parents, storeId.get(cur));
                int parent2 = findParent(parents, storeId.get(next));

                if (parent1 != parent2) {
                    union(parents, ranks, parent1, parent2);
                }
            }
        }

        Map<Integer, List<String>> indexToEmail = new HashMap<>();

        for (String email : storeId.keySet()) {
            int parent = findParent(parents, parents[storeId.get(email)]);
            List<String> account = indexToEmail.getOrDefault(parent, new ArrayList<>());
            account.add(email);
            indexToEmail.put(parent, account);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : indexToEmail.values()) {
            Collections.sort(emails);
            String name = storeName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            res.add(account);
        }
        return res;
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
    public int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }
}
