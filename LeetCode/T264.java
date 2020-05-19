/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 */
public class T264 {
    public int nthUglyNumber(int n) {
        int[] t = new int[n];
        t[0] = 1;
        int a = 0,b = 0,c = 0;
        for(int i = 1; i < n ;i++) {
            int u = Math.min(Math.min(2 * t[a], 3 * t[b]), 5 * t[c]);
            if(u == t[a] * 2) a++;
            if(u == t[b] * 3) b++;
            if(u == t[c] * 5) c++;
            t[i] = u;
        }
        return t[n - 1];
    }
}
