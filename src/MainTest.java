import Q1TO50.number36.Solution;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: TODO
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[9][9];
        boolean res = solution.isValidSudoku(board);
        System.out.println(res);
    }
}
