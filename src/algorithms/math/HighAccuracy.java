package algorithms.math;

/**
 * @author: Bright Chan
 * @date: 2020/8/24 17:51
 * @description: 高精度，竖式乘法
 */
public class HighAccuracy {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        // 可以指定结果长度
        int[] res = new int[220];
        int carry = 0, pos = res.length - 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                pos = 220 + i - num1.length() + j - num2.length() + 1;
                res[pos] += carry + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                if (res[pos] >= 10) {
                    carry = res[pos] / 10;
                    res[pos] = res[pos] % 10;
                }
                else {
                    carry = 0;
                }
            }
            res[pos - 1] = carry;
            carry = 0;
        }

        pos = 0;
        while (res[pos] == 0) pos++;
        StringBuilder str = new StringBuilder();
        for (int i = pos; i < res.length; i++) {
            str.append(res[i]);

        }
        return str.toString();
    }
}
