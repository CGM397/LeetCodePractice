package Q451TO500.number470;

/**
 * @author: Bright Chan
 * @date: 2021/9/5 13:35
 * @description: 数学
 */
public class Solution {
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    private int rand7() {
        return (int) (Math.random() * 7);
    }
}
