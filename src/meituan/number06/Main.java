package meituan.number06;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/8/22 9:59
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] store = scanner.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(store[i]);
        }
        Arrays.sort(nums);

        boolean[] visited = new boolean[n];
        getRes(nums, visited, n, 0);

        System.out.println(res.size());
        for (List<Integer> one : res) {
            for (int i : one) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> res = new ArrayList<>();
    private static Set<Stack<Integer>> set = new HashSet<>();
    private static Stack<Integer> oneRes = new Stack<>();
    private static void getRes(int[] nums, boolean[] visited, int n, int count) {
        if (count == n) {
            if (!set.contains(oneRes)) {
                res.add(new ArrayList<>(oneRes));
                Stack<Integer> tmp = new Stack<>();
                for (int i : oneRes) {
                    tmp.push(i);
                }
                set.add(tmp);
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
//                    if (i > 0 && nums[i - 1] == nums[i]) {
//                        continue;
//                    }
                    oneRes.push(nums[i]);
                    visited[i] = true;
                    getRes(nums, visited, n, count + 1);
                    visited[i] = false;
                    oneRes.pop();
                }
            }
        }
    }
}
