package Q1TO50.number26;

/**
 * @author: Bright Chan
 * @date: 2021/4/18 10:53
 * @description: 数组
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]){
                n++;
                nums[n] = nums[i + 1];
            }
        }
        return n + 1;
    }
}
