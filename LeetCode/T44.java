/**
 *https://leetcode-cn.com/problems/wildcard-matching
 * 总结
 *  jstart、istart 分别记录的是p中 *的下标位置、 以及对应的s的下标位置(即当p中指针指到*时，s的指针位置)
 *   因为 *可以匹配任意字符，包括空字符  那么就先让 *匹配空字符
 *   此时 p中的指针位置位于*的后一位，s中的指针位置就是刚才istart指针的位置
 *   然后开始进行匹配，如果不匹配 则
 *   p中的指针仍然回到*的后一位，而s中的指针位置+1(这是关键：这就代表着+1前s那个位置的字符就被当作是被*给匹配了)
 *   然后 让*的后一位继续 与 s中+1位置的那个位置 匹配
 *
 *   以上是关键点、关键思路  其它细节 自己具体分析。
 *   比如
 *   s ： a b c d e f g h    p ： a b * ? f g h
 *   p ： a b * ? f g h
 *
 *   核心思路：
 *     找到p中 *号的位置、以及*号即将要匹配的s中的那个字符的位置。 即 jstart、istart才是关键
 */
public class T44 {
    public boolean isMatch(String s, String p) {
        if (p==null||p.isEmpty())return s==null||s.isEmpty();
        int i=0,j=0,istart=-1,jstart=-1,slen=s.length(),plen=p.length();
        //判断s的所有字符是否匹配
        while (i<slen){
            //三种匹配成功情况以及匹配失败返回false
            if (j<plen&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')){
                i++;
                j++;
            }else if (j<plen&&p.charAt(j)=='*'){
                istart=i;
                jstart=j++;
            }else if (istart>-1){
                i=++istart;
                j=jstart+1;
            }else {
                return false;
            }
        }
        //s中的字符都判断完毕，则认为s为空，此时需要p为空或者p中只剩下星号的时候，才能成功匹配。
        //如果p中剩余的都是*，则可以移除剩余的*
        while (j<plen&&p.charAt(j)=='*')j++;
        return j==plen;
    }

    /**
     * DP解法
     * @param s
     * @param p
     * @return
     */
    public boolean useDP(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
