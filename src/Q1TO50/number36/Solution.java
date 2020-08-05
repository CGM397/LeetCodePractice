package Q1TO50.number36;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/8/5 11:59
 * @description: 哈希表
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        char[] nums = new char[9];
        for (int i = 0;  i < 9; i++) {
            if (isNotValid(board[i])) return false;
            for (int j = 0; j < 9; j++) {
                nums[j] = board[j][i];
            }
            if (isNotValid(nums)) return false;
        }

        for (int k = 0; k < 9; k+= 3) {
            for (int i = 0; i < 9; i+=3) {
                int count = 0;
                for (int j = 0; j < 3; j++) {
                    nums[count + j] = board[i][k + j];
                    nums[count + 3 + j] = board[i + 1][k + j];
                    nums[count + 6 + j] = board[i + 2][k + j];
                }
                if (isNotValid(nums)) return false;
            }
        }
        return true;
    }

    private boolean isNotValid(char[] nums) {
        Map<Character, Integer> store = new HashMap<>(9);
        String num = "123456789";
        for (int k = 0; k < 9; k++) {
            store.put(num.charAt(k), 0);
        }
        for (char key : nums) {
            if (key == '.') continue;
            if (store.get(key) >= 1) return true;

            store.put(key, store.get(key) + 1);
        }
        return false;
    }
}
