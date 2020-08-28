package Q651TO700.number657;

/**
 * @author: Bright Chan
 * @date: 2020/8/28 9:30
 * @description: 模拟
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() < 1) return true;

        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
            }
        }
        return x == 0 && y == 0;
    }
}
