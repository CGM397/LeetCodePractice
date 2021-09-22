package huawei.number07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/22 18:59
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] v = parseToArray(scanner.nextLine());
        int[] t = parseToArray(scanner.nextLine());
        int[] d = parseToArray(scanner.nextLine());

        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(t[i], d[i], v[i]);
        }
        Arrays.sort(tasks, comparator);
        System.out.println(greedyChoose(tasks, n));
    }

    private static int greedyChoose(Task[] tasks, int n) {
        int totalTime = 0;
        int res = 0;
        for(int j = 0; j < n; j++) {
            if(tasks[j].endTime >= (tasks[j].costTime + totalTime)) {
                totalTime += tasks[j].costTime;
                res += tasks[j].value;
            }
        }
        return res;
    }

    private static int[] parseToArray(String line) {
        String[] store = line.split(" ");
        int[] res = new int[store.length];
        for (int i = 0; i < store.length; i++) {
            res[i] = Integer.parseInt(store[i]);
        }
        return res;
    }

    private final static Comparator<Task> comparator = (o1, o2) -> {
        if (o1.value > o2.value) {
            return -1;
        }
        else if (o1.value == o2.value) {
            return o1.costTime - o2.costTime;
        }
        else {
            return 1;
        }
    };

    public static class Task {
        int costTime;
        int endTime;
        int value;
        public Task (int costTime, int endTime, int value) {
            this.costTime = costTime;
            this.endTime = endTime;
            this.value = value;
        }
    }
}
