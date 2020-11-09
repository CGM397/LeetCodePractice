package Q951TO1000.number973;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Bright Chan
 * @date: 2020/11/9 10:23
 * @description: 优先队列；自定义排序
 */
public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
        return Arrays.copyOfRange(points, 0, K);
    }
    public int[][] myKClosest(int[][] points, int K) {
        Comparator<MyNum> cmp = Comparator.comparingInt(o -> o.distance);
        PriorityQueue<MyNum> store = new PriorityQueue<>(cmp);

        for (int[] point : points) {
            MyNum myNum = new MyNum(point[0], point[1],
                    (point[0] * point[0]) + (point[1] * point[1]));
            store.add(myNum);
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K && !store.isEmpty(); i++) {
            MyNum one = store.poll();
            res[i][0] = one.x;
            res[i][1] = one.y;
        }

        return res;
    }

    public static class MyNum {
        int x, y, distance;

        public MyNum(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
