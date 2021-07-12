package Q251TO300.number275;

/**
 * @author: Bright Chan
 * @date: 2021/7/12 22:27
 * @description: 排序
 */
public class Solution {
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length - 1, len = citations.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (len - mid <= citations[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return len - low;
    }
}
