package Q301TO350.number344;

/**
 * @author: Bright Chan
 * @date: 2020/10/8 10:09
 * @description: 双指针
 */
public class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length < 1) return;

        int left = 0, right = s.length - 1;
        char tmp;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
