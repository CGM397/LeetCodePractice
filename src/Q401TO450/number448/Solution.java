package Q401TO450.number448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2021/2/13 10:55
 * @description: 原地修改；可以利用原来的数组作为哈希表，每遇到一个数x(先对n取模)，就让nums[x- 1]增加n。
 *               最后遍历数组，取不超过n的数组下标+1的集合，即为所求
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int tmp = nums[cur - 1];
            while (cur != tmp && nums[i] != i + 1) {
                nums[cur - 1] = cur;
                nums[i] = tmp;

                cur = nums[i];
                tmp = nums[cur - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) res.add(i + 1);
        }
        return res;
    }
}
