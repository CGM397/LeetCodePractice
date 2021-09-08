package huawei.number05;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/9/8 18:56
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String targetModule = scanner.nextLine();

        Map<String, List<String>> store = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(",");
            String module = line[0];

            int time = Integer.parseInt(line[1]);
            times.put(module, time);

            List<String> tmp = store.getOrDefault(module, new ArrayList<>());
            tmp.addAll(Arrays.asList(line).subList(2, line.length));
            store.put(module, tmp);
            visited.put(module, 0);
        }

        int res = getTime(targetModule, store, times);

        if (flag) {
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }

    private static boolean flag = false;
    private static Map<String, Integer> visited = new HashMap<>();
    private static int getTime(String module, Map<String, List<String>> store,
                               Map<String, Integer> times) {
        if (flag) return -1;
        if (!store.containsKey(module) || visited.get(module) == 1) {
            flag = true;
            return -1;
        }
        int time = times.get(module);
        visited.put(module, 1);
        List<String> list = store.get(module);
        int max = 0;
        for (String one : list) {
            max = Math.max(max, getTime(one, store, times));
        }
        visited.put(module, 2);
        return time + max;
    }
}
