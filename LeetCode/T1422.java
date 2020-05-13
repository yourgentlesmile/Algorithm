/**
 * https://leetcode-cn.com/problems/maximum-score-after-splitting-a-string/
 */
public class T1422 {
    public int maxScore(String s) {
        int one = 0;
        char[] array = s.toCharArray();
        for(char c : array) {
            if(c == '1') one++;
        }
        int overOne = 0;
        int maxScore = -1;
        for(int i = 0;i < array.length - 1; i++) {
            if(array[i] == '1') {
                overOne++;
            }
            maxScore = Math.max(((i + 1) - overOne + one - overOne), maxScore);
        }
        return maxScore;
    }
}
