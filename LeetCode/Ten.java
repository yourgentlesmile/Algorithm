/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 *
 *
 * 进阶解法：一步到位直接按正则表达式的实现来:生成有限状态机
 */
public class Ten {
    private static Boolean[][] result;
    public static boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();

        boolean head = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*') {
            // 1、前面一个都不匹配 2、前面匹配一个，* 继续匹配
            return isMatch(s,p.substring(2)) || (head && isMatch(s.substring(1), p));
        }else {
            return head && isMatch(s.substring(1),p.substring(1));
        }
    }

    /**
     * 自底向上
     * @param text
     * @param pattern
     * @return
     */
    public static boolean v1(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length() - 1; i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                (pattern.charAt(j) == text.charAt(i) ||
                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
    //需要理解DP，再进一步优化
    public static boolean isMatch_dp(String s, String p) {
        result = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s.toCharArray(), p.toCharArray());
    }
    public static boolean dp(int i, int j, char[] s, char[] p) {
        if (result[i][j] != null) {
            result[i][j] = true;
        }
        boolean ans;
        if(j == p.length) {
            ans = i == s.length;
        } else {
            boolean firstMatch = (i < s.length && (s[i] == p[j] || p[j] == '.'));
            if(j + 1 < p.length && p[j + 1] == '*')
                ans = dp(i,j + 2, s, p) || (firstMatch && dp(i + 1, j ,s ,p));
            else {
                ans = firstMatch && dp(i + 1, j + 1, s, p);
            }
        }
        result[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isMatch_dp("aa", "a*"));
    }
}
