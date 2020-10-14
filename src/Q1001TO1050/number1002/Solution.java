package Q1001TO1050.number1002;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/10/14 9:06
 * @description: 字符串
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A == null) return res;

        String start = A[0];
        for (int i = 0; i < start.length(); i++) {
            char one = start.charAt(i);
            boolean flag = true;
            for (int j = 1; j < A.length; j++) {
                int index = A[j].indexOf(one);
                if (index != -1) {
                    A[j] = A[j].substring(0, index) + "1" + A[j].substring(index + 1);
                }
                else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res.add(one + "");
            }
        }
        return res;
    }
}
