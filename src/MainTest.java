import Q701TO750.number714.Solution;



/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{4,5,2,4,3,3,1,2,5,4};
        int fee = 1;
        System.out.println(solution.maxProfit(prices, fee));
    }
}
