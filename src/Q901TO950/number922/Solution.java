package Q901TO950.number922;

/**
 * @author: Bright Chan
 * @date: 2020/11/12 10:32
 * @description: 数组
 */
public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] odds = new int[A.length / 2];
        int[] evens = new int[A.length / 2];
        int countOdd = 0, countEven = 0;

        for (int i : A) {
            if (i % 2 == 0) {
                evens[countEven] = i;
                countEven++;
            }
            else {
                odds[countOdd] = i;
                countOdd++;
            }
        }

        int[] res = new int[A.length];
        countEven = countOdd = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                res[i] = evens[countEven];
                countEven++;
            }
            else {
                res[i] = odds[countOdd];
                countOdd++;
            }
        }
        return res;
    }
}
