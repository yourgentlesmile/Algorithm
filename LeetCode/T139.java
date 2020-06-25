import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-break
 *
 * 动态规划：
 * dp[i] = dp[j] && check(j,i)
 * dp[j]表示0~j之间的字符串符合题目要求，
 * 自然的dp[i] 就是dp[j] 加上新增的j~i这段字符串是否在dict当中，如果在
 * 则0~i自然也是符合题意的
 */
public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1;i <= s.length();i++) {
            for(int j = 0;j < i;j++) {
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
