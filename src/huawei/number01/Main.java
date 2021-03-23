package huawei.number01;

/**
 * @author: Bright Chan
 * @date: 2021/3/22 19:48
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        int[] store = new int[]{2,3,1,2,4,7};
        int s = 7;
        getRes(store, s);
    }

    private static void getRes(int[] store, int s) {
        int left = 0, right = 1, len = store.length, count = 0;
        int res = len + 1;

        count += store[0];
        if (count >= s) {
            res = Math.min(res, 1);
        }
        while (right < len) {
            count += store[right];
            if (count >= s) {
                while (left < len && count >= s) {
                    count -= store[left];
                    left++;
                }
                res = Math.min(right - left + 2, res);
            }
            right++;
        }
        System.out.println(res);
    }
}
