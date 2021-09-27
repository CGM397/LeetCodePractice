package tencent.number08;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/26 19:55
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] store = new int[n];
        for (int i = 0; i < n; i++) {
            store[i] = scanner.nextInt();
        }

        int[] preSum = new int[n];
        preSum[0] = store[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + store[i];
        }

        // 从第i个数开始的2的j次方个数的最值
        int[][] maxSum = new int[n + 1][20];
        int[][] minSum = new int[n + 1][20];
        for (int i = 1; i <= n; i++) {
            maxSum[i][0] = store[i - 1];
            minSum[i][0] = store[i - 1];
        }
        for(int j = 1; j < 20; ++j){
            for(int i = 1; i <= n; ++i) {
                if(i + (1 << j) - 1 <= n) {
                    maxSum[i][j] = Math.max(maxSum[i][j - 1], maxSum[i + (1 << (j - 1))][j - 1]);
                    minSum[i][j] = Math.min(minSum[i][j - 1], minSum[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            int max, min;
            // 三段
            if (i > 0 && i < n - k) {
                // [0, i - 1]
                int[] tmp = maxAndMin(1, i, maxSum, minSum);
                int max1 = tmp[0];
                int min1 = tmp[1];
                // [i, i + k - 1]
                int avg = (preSum[i + k - 1] - preSum[i - 1]) / k;
                // [i + k, n - 1]
                tmp = maxAndMin(i + k + 1, n, maxSum, minSum);
                int max2 = tmp[0];
                int min2 = tmp[1];

                max = Math.max(Math.max(max1, avg), max2);
                min = Math.min(Math.min(min1, avg), min2);
            }
            // 两段
            else if (i == 0) {
                // [0, k - 1]
                int avg = preSum[k - 1] / k;
                // [k, n - 1]
                int[] tmp = maxAndMin(k + 1, n, maxSum, minSum);
                int max1 = tmp[0];
                int min1 = tmp[1];

                max = Math.max(max1, avg);
                min = Math.min(min1, avg);
            }
            // 两段
            else {
                // [0, n - k - 1]
                int[] tmp = maxAndMin(1, n - k, maxSum, minSum);
                int max1 = tmp[0];
                int min1 = tmp[1];
                // [n - k, n - 1]
                int avg = (preSum[n - 1] - preSum[n - k - 1]) / k;

                max = Math.max(max1, avg);
                min = Math.min(min1, avg);
            }
            res = Math.min(max - min, res);
        }
        System.out.println(res);
    }

    private static int[] maxAndMin(int i, int j, int[][] maxSum, int[][] minSum) {
        int magic = (int) (Math.log(j - i + 1) / Math.log(2));
        int max = Math.max(maxSum[i][magic], maxSum[j - (1 << magic) + 1][magic]);
        int min = Math.min(minSum[i][magic], minSum[j - (1 << magic) + 1][magic]);
        return new int[]{max, min};
    }
}
