package shopee.number01;

/**
 * @author: Bright Chan
 * @date: 2021/7/5 15:20
 * @description: 数组
 */
public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param petals int整型一维数组 花瓣数
     * @return int整型
     */
    public int petalsBreak(int[] petals) {
        int res = 0;
        for (int one : petals) {
            res += one / 2 + one % 2;
        }
        return res;
    }
}
