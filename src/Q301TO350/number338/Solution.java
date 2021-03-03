package Q301TO350.number338;

/**
 * @author: Bright Chan
 * @date: 2021/3/3 15:22
 * @description: 数组
 */
public class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}
