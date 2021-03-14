package meituan.number05;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/3/13 17:32
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        int[] height = new int[n];
        String[] tmp = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(tmp[i]);
        }

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
            scanner.nextLine();
            edges[i][0] = x;
            edges[i][1] = y;
        }

        getRes(height, edges, n, m);
    }

    private static void getRes(int[] height, int[][] edges, int n, int m) {
        List<Num> store = new ArrayList<>();
        store.sort(cmp);
        System.out.println(4);
    }

    private static int res = 0;
    private static Stack<Integer> store;
    private static void dfs(int index, int[] height, int[][] edges, boolean[] flag) {
        int i = 0;
        for (; i < flag.length; i++) {
            if (!flag[i]) {
                break;
            }
        }
    }

    private static class Num {
        int index;
        int val;
        public Num(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    private static Comparator<Num> cmp = (o1, o2) -> o2.val - o1.val;
}
