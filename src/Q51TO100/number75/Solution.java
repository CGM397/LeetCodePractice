package Q51TO100.number75;

/**
 * @author: Bright Chan
 * @date: 2020/10/5 15:05
 * @description: 排序
 */
public class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;

        for (int i : nums) {
            if (i == 0) red++;
            else if (i == 1) white++;
            else if (i == 2) blue++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (red != 0) {
                nums[i] = 0;
                red--;
            }
            else if (white != 0) {
                nums[i] = 1;
                white--;
            }
            else if (blue != 0) {
                nums[i] = 2;
                blue--;
            }
        }
    }

    /**
     * 荷兰三色旗问题解
     * @param nums 给定数组
     */
    public void officialSolution(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }
}
