package Q2401TO2450.number2437;

/**
 * @author: Solution
 * @date: 2023/5/9 22:36
 * @description: countTime
 */
public class Solution {
    public int countTime(String time) {
        char h0 = time.charAt(0);
        char h1 = time.charAt(1);
        char m0 = time.charAt(3);
        char m1 = time.charAt(4);

        int countH, countM;

        if (h0 == '?' && h1 == '?') {
            countH = 24;
        }
        else if (h0 == '?') {
            if (h1 < '4') {
                countH = 3;
            }
            else {
                countH = 2;
            }
        }
        else if (h1 == '?') {
            if (h0 < '2') {
                countH = 10;
            }
            else {
                countH = 4;
            }
        }
        else {
            countH = 1;
        }

        if (m0 == '?' && m1 == '?') {
            countM = 60;
        }
        else if (m0 == '?') {
            countM = 6;
        }
        else if (m1 == '?') {
            countM = 10;
        }
        else {
            countM = 1;
        }

        return countH * countM;
    }
}
