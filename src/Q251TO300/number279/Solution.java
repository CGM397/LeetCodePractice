package Q251TO300.number279;

/**
 * @author: Bright Chan
 * @date: 2021/3/29 15:30
 * @description: TODO
 */
public class Solution {
    public int numSquares(int n) {
        dfs((int) Math.sqrt(n), n, 0);
        return count;
    }

    private int count = 0;
    private boolean find = false;
    private void dfs (int num, int n, int sum) {
        if (find) {
            return;
        }

        int tmp = sum + num * num;
        if (tmp > n) {
            dfs(num - 1, n, sum);
        }
        else if (tmp == n) {
            count++;
            find = true;
        }
        else {
            count++;
            dfs(num, n, tmp);
        }
    }
}
