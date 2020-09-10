package Q51TO100.number66;

/**
 * @author: Bright Chan
 * @date: 2020/9/10 13:26
 * @description: 数组
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] < 10) {
                carry = 0;
                break;
            }
            else
                digits[i] = digits[i] % 10;
        }

        int[] res;
        if (carry == 1) {
            res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
        }
        else {
            res = new int[digits.length];
            System.arraycopy(digits, 0, res, 0, digits.length);
        }
        return res;
    }
}
