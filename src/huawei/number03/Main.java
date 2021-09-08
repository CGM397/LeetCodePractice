package huawei.number03;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/9/8 18:56
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] tmp = scanner.nextLine().split(" ");
        int[] values = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(tmp[i]);
            sum += values[i];
        }

        Map<Integer, List<Integer>> store = new HashMap<>();
        while (scanner.hasNext()) {
            int key = scanner.nextInt(), val = scanner.nextInt();
            scanner.nextLine();

            List<Integer> vals = store.getOrDefault(key, new ArrayList<>());
            vals.add(val);
            store.put(key, vals);
        }

        int sum1, sub = Integer.MIN_VALUE, minIndex = -1;
        for (int i = 1; i < n; i++) {
            sum1 = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                sum1 += values[cur];
                if (store.containsKey(cur)) {
                    List<Integer> list = store.get(cur);
                    for (int one : list) {
                        queue.offer(one);
                    }
                }
            }
            if (Math.abs(sum - 2 * sum1) > sub) {
                sub = Math.abs(sum - 2 * sum1);
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }
}
