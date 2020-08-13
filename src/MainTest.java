import Q1TO50.number37.Solution;

/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: TODO
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] tmp = new String[][]{{".",".","9","7","4","8",".",".","."},{"7",".",".",".",".",".",".",".","."},{".","2",".","1",".","9",".",".","."},{".",".","7",".",".",".","2","4","."},{".","6","4",".","1",".","5","9","."},{".","9","8",".",".",".","3",".","."},{".",".",".","8",".","3",".","2","."},{".",".",".",".",".",".",".",".","6"},{".",".",".","2","7","5","9",".","."}};
        char[][] board = new char[tmp.length][tmp[0].length];
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                board[i][j] = tmp[i][j].charAt(0);
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution.solveSudoku(board);
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
