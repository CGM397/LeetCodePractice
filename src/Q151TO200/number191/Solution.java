package Q151TO200.number191;

/**
 * @author: Bright Chan
 * @date: 2021/3/22 10:34
 * @description: 字符
 */
public class Solution {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
