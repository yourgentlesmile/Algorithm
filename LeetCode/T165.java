/**
 * https://leetcode-cn.com/problems/compare-version-numbers
 */
public class T165 {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        for(int i = 0;i <= Math.max(a.length - 1,b.length - 1);i++) {
            String l = i >= a.length ? "0" : a[i];
            String r = i >= b.length ? "0" : b[i];
            if(Integer.parseInt(l) > Integer.parseInt(r)) return 1;
            else if(Integer.parseInt(l) == Integer.parseInt(r)) continue;
            else return -1;
        }
        return 0;
    }
}
