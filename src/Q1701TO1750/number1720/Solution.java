package Q1701TO1750.number1720;

/**
 * @author: Bright Chan
 * @date: 2021/5/6 16:16
 * @description: 异或
 */
public class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }
}
