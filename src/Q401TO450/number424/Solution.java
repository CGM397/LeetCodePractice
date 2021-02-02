package Q401TO450.number424;

/**
 * @author: Bright Chan
 * @date: 2021/2/2 10:59
 * @description: 滑动窗口；双指针
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        // 当前窗口中出现次数最多的字母的个数
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            int indexR = s.charAt(right) - 'A';
            num[indexR]++;
            maxn = Math.max(maxn, num[indexR]);

            // 当窗口中除了maxn对应的字母之外的其他所有字母的个数总和大于K的时候，
            // 就无法进行替换，所以窗口左端往右移动一格，这样可以保证区间长度不减小，
            // 因为窗口右端也往右移动了一格，所以到最后的时候 right - left 即为所求
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
