package Q1351TO1400.number1365;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/10/26 9:19
 * @description: 排序
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        List<Integer> store = new ArrayList<>();
        for (int i : tmp) store.add(i);


        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = store.indexOf(nums[i]);
        }
        return res;
    }
}
