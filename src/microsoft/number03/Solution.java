package microsoft.number03;

/**
 * @author: Bright Chan
 * @date: 2021/9/20 20:33
 * @description: TODO
 */
public class Solution {
    public int solution(String S){
        int sum = 0;
        for(int i = 0 ; i < S.length() ; i ++){
            sum += S.charAt(i) - '0';
        }
        int now = sum % 3;
        int result = 0;
        for(int i = 0 ; i < S.length() ; i ++){
            for(int j = 0 ; j < 3 ; j ++) {
                int x = j - (S.charAt(i) - '0');
                if((x + sum) % 3 == 0){
                    result += (9 - j) / 3 + 1;
                    break;
                }
            }
        }
        if(now == 0){
            result -= S.length() - 1;
        }
        return result;
    }
}
