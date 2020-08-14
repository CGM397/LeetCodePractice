package Q1TO50.number41;

/**
 * @author: Bright Chan
 * @date: 2020/8/13 20:53
 * @description: 数组。需要知道的是，结果一定属于1到n+1这个区间内；
 *               技巧是，利用数据本身，使其作为一个哈希表的代替。
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) return 1;

        int tmp;
        // 如果原数组中没有1，则返回1，因为后面的操作会将一些值变为1，所以需要先做判断
        // 变为1的依据：最后的解一定属于1到n+1这个区间内，所以其他值没有影响
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) flag = true;
            if (nums[i] <= 0 || nums[i] > nums.length)
                nums[i] = 1;
        }
        if (!flag) return 1;

        // 将当前得到的值tmp对应的下标减一的位置tmp-1(防止越界访问)的值置为负数，
        // 表示tmp已经出现在原数组中了
        for (int i = 0; i < nums.length; i++) {
             tmp = Math.abs(nums[i]);
             nums[tmp - 1] = -Math.abs(nums[tmp - 1]);
        }
        tmp = -1;
        // 遍历数组，找到第一个为正数的位置下标+1即为解
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                tmp = i + 1;
                break;
            }
        }
        //若没有正数，则说明数组中有1到n的所有数字，所以最小值为n+1
        if (tmp == -1) tmp = nums.length + 1;
        return tmp;
    }
}
