/**
 * https://leetcode-cn.com/problems/is-subsequence/
 * 最优解法：使用动态规划预处理字符串t
 * f[i][j] = k
 * i 往后位置字母j第一次出现的位置为k
 *
 */
public class T392 {

    /**
     * 非最优
     */
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(t.length() == 0) return false;
        int start = 0;
        for(int i = 0;i < t.length();i++) {
            if(s.charAt(start) == t.charAt(i)) {
                start++;
                if(start == s.length()) return true;
            }
        }
        return false;
    }

    /**
     * DP最优解
     */
    public boolean bestDP(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
