package Q51TO100.number79;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/9/13 10:01
 * @description: 回溯算法，需要区分大小写...
 */
public class Solution {

    private boolean[][] flags;
    private boolean res = false;
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length < 1 || word.length() < 1) return false;

        flags = new boolean[board.length][board[0].length];
        for (boolean[] one : flags)
            Arrays.fill(one, false);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    dfs(board, word, i, j, 0);
            }
        }
        return res;
    }

    private void dfs(char[][] board, String word, int x, int y, int pos) {
        if (board[x][y] == word.charAt(pos)) {
            flags[x][y] = true;
            pos++;
            if (pos == word.length()) {
                res = true;
                return;
            }
            if (x + 1 < board.length && !flags[x + 1][y]) {
                dfs(board, word, x + 1, y, pos);
                if (res) return;
            }
            if (x - 1 >= 0 && !flags[x - 1][y]) {
                dfs(board, word, x - 1, y, pos);
                if (res) return;
            }
            if (y + 1 < board[0].length && !flags[x][y + 1]) {
                dfs(board, word, x, y + 1, pos);
                if (res) return;
            }
            if (y - 1 >= 0 && !flags[x][y - 1]) {
                dfs(board, word, x, y - 1, pos);
            }
            flags[x][y] = false;
        }
    }
}
