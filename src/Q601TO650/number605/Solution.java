package Q601TO650.number605;

/**
 * @author: Bright Chan
 * @date: 2021/1/1 11:05
 * @description: 贪心
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int index = 0, len = flowerbed.length;
        while (n > 0 && index < len) {
            if (flowerbed[index] == 0) {
                if (index == 0 || flowerbed[index - 1] == 0) {
                    if (index == len - 1 || flowerbed[index + 1] == 0) {
                        flowerbed[index] = 1;
                        n--;
                    }
                }
            }
            index++;
        }

        return n == 0;
    }
}
