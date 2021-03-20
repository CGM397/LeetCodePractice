import Q101TO150.number150.Solution;



/**
 * @author: Bright Chan
 * @date: 2020/7/23 21:37
 * @description: 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens));
    }
}
