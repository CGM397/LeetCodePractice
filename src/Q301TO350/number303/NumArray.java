package Q301TO350.number303;

/**
 * @author: Bright Chan
 * @date: 2021/3/1 13:41
 * @description: 前缀和
 */
public class NumArray {

    // 前缀和
    private int[] store;

    public NumArray(int[] nums) {
        store = new int[nums.length + 1];
        store[0] = 0;

        for (int i = 1; i <= nums.length; i++) {
            store[i] = store[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return store[j + 1] - store[i];
    }
}
