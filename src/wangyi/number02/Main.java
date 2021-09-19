package wangyi.number02;

/**
 * @author: Bright Chan
 * @date: 2021/9/18 19:44
 * @description: TODO
 */
public class Main {
    public int minCost(int a, int b, int c, int x, int y, int z) {
        int bMax = bMax(a, b, c, x, z);
        int bMin = bMin(a, b, c, x, y, z);

        return Math.min(bMax, bMin);
    }

    // b是最大的
    private static int bMax(int a, int b, int c, int x, int z) {
        int cost = 0;

        if (a >= b) {
            cost += (a - b + 1) * x;
            a = b - 1;
        }
        if (c >= b) {
            cost += (c - b + 1) * z;
            c = b - 1;
        }
        if (a == c) {
            cost += Math.min(x, z);
        }
        return cost;
    }

    // b是最小的
    private static int bMin(int a, int b, int c, int x, int y, int z) {
        int cost = 0;

        // 先处理a, c
        if (a == c) {
            cost += Math.min(x, z);
            if (x > z) c--;
            else a--;
        }

        if (b >= a) {
            cost += (b - a + 1) * y;
            b = a - 1;
        }
        if (b >= c) {
            cost += (b - c + 1) * y;
        }
        return cost;
    }
}
