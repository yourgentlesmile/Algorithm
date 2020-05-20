import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
 */
public class T1371 {
    public int findTheLongestSubstring(String s) {
        int[] r = new int[32];
        Arrays.fill(r, -1);
        r[0] = 0;
        int res = 0;
        int status = 0;
        for(int i = 0;i < s.length();i++) {
            char k = s.charAt(i);
            if(k == 'a') {
                status ^= 1 << 0;
            }else if(k == 'e') {
                status ^= 1 << 1;
            }else if(k == 'i') {
                status ^= 1 << 2;
            }else if(k == 'o') {
                status ^= 1 << 3;
            }else if(k == 'u') {
                status ^= 1 << 4;
            }
            if(r[status] >= 0) {
                res = Math.max(res, i + 1 - r[status]);
            } else {
                r[status] = i + 1;
            }
        }
        return res;
    }
}
