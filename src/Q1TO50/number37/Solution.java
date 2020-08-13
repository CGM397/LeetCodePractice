package Q1TO50.number37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/5 17:58
 * @description: 回溯算法
 */
public class Solution {

    //存放所有需要填充的格子的位置
    private List<Integer> store = new ArrayList<>();
    private Character[] num = new Character[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private boolean flag = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    store.add(i);
                    store.add(j);
                }
            }
        }
        backTracking(0, board);
    }

    private void backTracking(int nextPos, char[][] board) {
        if (nextPos == store.size()) {
            flag = true;
            return;
        }
        int i = store.get(nextPos);
        int j = store.get(nextPos + 1);
        List<Character> candidateNum = new ArrayList<>(num.length);
        Collections.addAll(candidateNum, num);
        //行
        for (int m = 0; m < board[i].length; m++) {
            if (candidateNum.contains(board[i][m]))
                candidateNum.remove((Character) board[i][m]);
        }
        //列
        for (char[] chars : board) {
            if (candidateNum.contains(chars[j]))
                candidateNum.remove((Character) chars[j]);
        }
        //九宫格
        int m = (i / 3) * 3;
        int n = (j / 3) * 3;
        for (int k = m; k <= m + 2; k++) {
            for (int l = n; l <= n + 2; l++) {
                if (candidateNum.contains(board[k][l]))
                    candidateNum.remove((Character) board[k][l]);
            }
        }

        for (Character character : candidateNum) {
            board[i][j] = character;
            backTracking(nextPos + 2, board);
            if (flag) return;
            board[i][j] = '.';
        }
    }
}
