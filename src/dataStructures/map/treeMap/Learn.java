package dataStructures.map.treeMap;

import java.util.TreeMap;

/**
 * @author: Bright Chan
 * @date: 2021/2/4 17:17
 * @description: TreeMap是可以对key进行排序的map
 */
public class Learn {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(2, 1);
        map.put(1, 2);
        map.put(3, 1);

        // 得到最小key对应的键值对（如果按照自然排序的话）
        System.out.println(map.firstEntry().getKey());
        // 得到最大key对应的键值对（如果按照自然排序的话）
        System.out.println(map.lastEntry().getKey());
    }
}
