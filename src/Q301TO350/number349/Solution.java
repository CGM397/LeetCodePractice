package Q301TO350.number349;

import java.util.*;

/**
 * @author: Bright Chan
 * @date: 2020/11/2 10:46
 * @description: 数组
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> store = new HashSet<>();
        for (int i : nums2) store.add(i);

        for (int i : nums1) {
            if (store.contains(i)) res.add(i);
        }

        int[] uniqueRes = new int[res.size()];
        int count = 0;
        for (int i : res) {
            uniqueRes[count] = i;
            count++;
        }
        return uniqueRes;
    }
}
