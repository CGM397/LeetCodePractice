package ali.number01;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/3/8 19:00
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            String[] store = scanner.nextLine().split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(store[j]);
            }
            getK(nums, k);
        }
    }

    private static void getK(int[] nums, int k) {
        int index = 1, tmp = nums[0] + 1, n = nums.length;

        while (k > 0 && index < n) {
            // 找到一个空缺的元素
            if (nums[index] != tmp) {
                tmp++;
                k--;
            }
            // 数组中有这个元素，所以看下一个元素
            else {
                tmp++;
                index++;
            }
        }
        // 比最大的元素都大
        if (index == n) {
            System.out.println(tmp + k - 1);
        }
        else {
            System.out.println(tmp - 1);
        }
    }
}
