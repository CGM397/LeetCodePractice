package dataStructures.graph.unionFindSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2021/1/26 10:46
 * @description: 二维数组，映射为一维数组；类模式；只针对横、纵坐标只要一个相等就同属一个集合的场合
 */
public class UnionFindMulti {
    private Map<Integer, Integer> parent;
    private int count;

    public UnionFindMulti() {
        this.parent = new HashMap<>();
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public int find(int node) {
        if (!parent.containsKey(node)) {
            parent.put(node, node);
            // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
            count++;
        }

        if (node != parent.get(node)) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }

        parent.put(rootX, rootY);
        // 两个连通分量合并成为一个，连通分量的总数 -1
        count--;
    }
}
