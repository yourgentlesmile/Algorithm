import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
 * 由于需要出现的元音字母恰好出现偶数次，可以用位的异或运算代表奇偶性
 * 然后再根据
 * 偶数减偶数一定是偶数
 * 奇数减奇数一定是偶数
 *
 * 能命中同一个slot，代表奇偶性一定是相同的，所以只需要计算一下距离就可以了
 */
public class T1371 {
    public int findTheLongestSubstring(String s) {
        int[] r = new int[1 << 5];
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
