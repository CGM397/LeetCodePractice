package Q101TO150.number139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Bright Chan
 * @date: 2020/11/1 13:22
 * @description: 动态规划
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // dp[i]表示字符串s前i个字符组成的字符串s[0..i−1]是否能被空格拆分成若干个字典中出现的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 转移时，新加入一个字符，需要重新检查一遍之前的字符串
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
