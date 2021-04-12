package Q151TO200.number179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Bright Chan
 * @date: 2021/4/12 11:09
 * @description: 排序
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] store = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            store[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(store, comparator);

        int index = 0;
        while (index + 1 < nums.length) {
            int cur = Integer.parseInt(store[index]);
            int next = Integer.parseInt(store[index + 1]);
            if (cur == 0 && next == 0) index++;
            else break;
        }
        StringBuilder res = new StringBuilder();
        for (int i = index; i < nums.length; i++) {
            res.append(store[i]);
        }
        return res.toString();
    }

    private Comparator<String> comparator = (o1, o2) -> {
        int index = 0, len1 = o1.length(), len2 = o2.length();

        while (index < len1 && index < len2) {
            char cur1 = o1.charAt(index), cur2 = o2.charAt(index);
            if (cur1 > cur2) {
                return -1;
            }
            if (cur1 < cur2) {
                return 1;
            }
            index++;
        }
        if (index == len1 && index < len2) {
            if (o2.substring(index).equals(o1)) return 0;
            int left = 0, right = index;
            while (true) {
                if (o2.charAt(left) < o2.charAt(right)) {
                    return 1;
                }
                else if (o2.charAt(left) > o2.charAt(right)) {
                    return -1;
                }
                left++;
                right++;
                if (right == len2) {
                    right = 0;
                }
                if (left == len2) {
                    left = 0;
                }
            }
        }
        if (index == len2 && index < len1) {
            if (o1.substring(index).equals(o2)) return 0;
            int left = 0, right = index;
            while (true) {
                if (o1.charAt(left) < o1.charAt(right)) {
                    return -1;
                }
                else if (o1.charAt(left) > o1.charAt(right)) {
                    return 1;
                }
                left++;
                right++;
                if (right == len1) {
                    right = 0;
                }
                if (left == len1) {
                    left = 0;
                }
            }
        }
        return 0;
    };
}
