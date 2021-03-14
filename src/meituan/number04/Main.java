package meituan.number04;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2021/3/13 16:56
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        String[] tmp = scanner.nextLine().split(" ");
        int[] storeNum = new int[n];
        for (int i = 0; i < n; i++) {
            storeNum[i] = Integer.parseInt(tmp[i]);
        }

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            scanner.nextLine();
            edges[i][0] = x;
            edges[i][1] = y;
        }

        getRes(storeNum, edges, n, m);
    }

    private static void getRes(int[] storeNum, int[][] edges, int n, int m) {
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(flag, false);
            maxMinNum = 0;
            maxSum = 0;
            store = new Stack<>();
            flag[i] = true;
            dfs(storeNum, edges, m, flag, i);
        }
        System.out.println(maxSum + " " + maxMinNum);
    }

    private static int maxSum, maxMinNum;
    private static Stack<Integer> store;
    private static void dfs(int[] storeNum, int[][] edges, int m, boolean[] flag, int index) {
        int i = 0;
        for (; i < flag.length; i++) {
            if (!flag[i]) {
                break;
            }
        }
        if (i == flag.length) {
            int tmpSum = 0, tmpMaxMinNum = Integer.MAX_VALUE;
            Stack<Integer> swap = new Stack<>();
            while (!store.isEmpty()) {
                int cur = store.pop();
                tmpSum += cur;
                tmpMaxMinNum = Math.min(cur, tmpMaxMinNum);
                swap.push(cur);
            }
            while (!swap.isEmpty()) {
                store.push(swap.pop());
            }
            if (tmpSum > maxSum) {
                maxSum = tmpSum;
                maxMinNum = tmpMaxMinNum;
            }
            else if (tmpSum == maxSum && maxMinNum < tmpMaxMinNum) {
                maxMinNum = tmpMaxMinNum;
            }
            return;
        }

        for (i = 0; i < m; i++) {
            int x = edges[i][0] - 1, y = edges[i][1] - 1;
            if (x == index) {
                flag[y] = true;
            }
            if (y == index) {
                flag[x] = true;
            }
        }

        for (i = 0; i < m; i++) {
            int x = edges[i][0] - 1, y = edges[i][1] - 1;
            if (x != index && y != index) {
                if (!flag[x]) {
                    store.push(storeNum[x]);
                    flag[x] = true;
                    dfs(storeNum, edges, m, flag, x);
                    flag[x] = false;
                    store.pop();
                }
                if (!flag[y]) {
                    store.push(storeNum[y]);
                    flag[y] = true;
                    dfs(storeNum, edges, m, flag, y);
                    flag[y] = false;
                    store.pop();
                }
            }
        }
    }
}
