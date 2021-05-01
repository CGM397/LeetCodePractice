package Q651TO700.number690;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/5/1 11:29
 * @description: 广搜
 */
public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Employee> store = new LinkedList<>();
        for (Employee e : employees) {
            map.put(e.id, e);
            if (e.id == id) {
                store.offer(e);
            }
        }

        int res = 0;
        while (!store.isEmpty()) {
            Employee cur = store.poll();
            res += cur.importance;

            for (int i : cur.subordinates) {
                store.offer(map.get(i));
            }
        }
        return res;
    }

    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
