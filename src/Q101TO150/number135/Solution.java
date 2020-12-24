package Q101TO150.number135;

/**
 * @author: Bright Chan
 * @date: 2020/12/24 10:16
 * @description: 贪心算法
 */
public class Solution {
    public int candy(int[] ratings) {

        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] < min) {
                min = ratings[i];
                minIndex = i;
            }
        }

        int candyNum = 1;
        int[] store = new int[ratings.length];
        store[minIndex] = 1;
        for (int i = minIndex; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candyNum++;
                store[i - 1] = candyNum;
            }
            else if (ratings[i - 1] == ratings[i]) {
                candyNum = 1;
                store[i - 1] = candyNum;
            }
            else {
                if (candyNum == 1) {
                    store[i - 1] = candyNum;
                    int j = i - 1;
                    while (j < minIndex && ratings[j + 1] > ratings[j]) {
                        if (store[j + 1] <= store[j]) store[j + 1] = store[j] + 1;
                        j++;
                    }
                }
                else {
                    candyNum = 1;
                    store[i - 1] = candyNum;
                }
            }
        }

        candyNum = 1;
        for (int i = minIndex; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candyNum++;
                store[i + 1] = candyNum;
            }
            else if (ratings[i] == ratings[i + 1]) {
                candyNum = 1;
                store[i + 1] = candyNum;
            }
            else {
                if (candyNum == 1) {
                    store[i + 1] = candyNum;
                    int j = i + 1;
                    while (j > minIndex && ratings[j - 1] > ratings[j]) {
                        if (store[j - 1] <= store[j]) store[j - 1] = store[j] + 1;
                        j--;
                    }
                }
                else {
                    candyNum = 1;
                    store[i + 1] = candyNum;
                }
            }
        }
        int res = 0;
        for (int i : store) res += i;
        return res;
    }
}
