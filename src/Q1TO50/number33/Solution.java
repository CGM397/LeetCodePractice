package Q1TO50.number33;

/**
 * @author: Bright Chan
 * @date: 2020/8/4 10:09
 * @description: 二分查找
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length < 1) return -1;

        int left = 0, right = nums.length - 1, middle, midValue, startValue = nums[0];
        if (startValue == target) return 0;

        while (left <= right) {
            //防止left+right溢出
            middle = left + (right - left) / 2;
            midValue = nums[middle];
            if (target == midValue)
                return middle;
            else if (target < midValue) {
                //增加判断用于选择留下哪半边
                if (startValue < target)
                    right = middle - 1;
                else {
                    if (midValue >= startValue)
                        left = middle + 1;
                    else
                        right = middle - 1;
                }
            }
            else {
                //增加判断用于选择留下哪半边
                if (startValue > target)
                    left = middle + 1;
                else {
                    if (midValue < startValue)
                        right = middle - 1;
                    else
                        left = middle + 1;
                }
            }
        }
        return -1;
    }
    // 讨论区还有一个思路：二分搜索，如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，
    // 则左半段是有序的，我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
    // 和我上面这个方法的思路差不多
}
