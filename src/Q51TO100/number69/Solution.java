package Q51TO100.number69;

/**
 * @author: Bright Chan
 * @date: 2020/10/2 15:53
 * @description: 二分查找
 */
public class Solution {
    public int mySqrt(int x) {
        long low = 0, high = x, middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (middle * middle <= x) {
                if ((middle + 1) * (middle + 1) > x) return (int) middle;
                else if ((middle + 1) * (middle + 1) == x) return (int) (middle + 1);
                low = middle + 1;
            }
            else
                high = middle - 1;
        }
        return 0;
    }
}
