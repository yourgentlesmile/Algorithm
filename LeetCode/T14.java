/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 纵向扫描即可
 */
public class T14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for(int i = 0;i < strs.length;i++) {
            minLen = Math.min(strs[i].length(), minLen);
        }
        for(int i = 0;i < minLen;i++) {
            char c = strs[0].charAt(i);
            for(int j = 1;j < strs.length;j++) {
                if(c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
