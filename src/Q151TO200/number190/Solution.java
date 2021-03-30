package Q151TO200.number190;

/**
 * @author: Bright Chan
 * @date: 2021/3/29 10:46
 * @description: 数
 */
public class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
