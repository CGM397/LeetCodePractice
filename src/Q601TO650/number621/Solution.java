package Q601TO650.number621;

/**
 * @author: Bright Chan
 * @date: 2020/12/5 10:31
 * @description: 调度任务
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] store = new int[26];
        for (char one : tasks) store[one - 'A'] += 1;

        int maxNum = 0, maxNumIndex = 0;
        for (int i = 0; i < store.length; i++) {
            if (store[i] > maxNum) {
                maxNum = store[i];
                maxNumIndex = i;
            }
        }

        int count = 0;
        for (int one : store) {
            if (one == maxNum) count++;
        }
        count--;

        int res = maxNum * (n + 1) - n + count, left = (maxNum - 1) * n;
        if (n == 0) return tasks.length;
        for (int i = 0; i < store.length; i++) {
            if (i != maxNumIndex) {
                if (store[i] == maxNum) store[i] -= 1;
                if (left > 0) {
                    left -= store[i];
                    if (left < 0) {
                        res += -left;
                        left = 0;
                    }
                }
                else {
                    res += store[i];
                }
            }
        }

        return res;
    }
}
