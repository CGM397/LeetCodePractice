package Q1451TO1500.number1486;

/**
 * @author: Bright Chan
 * @date: 2021/5/7 9:50
 * @description: 异或操作
 */
public class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans ^= (start + i * 2);
        }
        return ans;
    }
}
