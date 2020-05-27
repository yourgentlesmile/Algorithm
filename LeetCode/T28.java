/**
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class T28 {
    public int strStr(String haystack, String needle) {
        for(int i = 0;i < haystack.length() - needle.length() + 1; i++) {
            boolean modify = false;
            if(haystack.substring(i, i + needle.length()).equals(needle))
                return i;
            while(i < haystack.length() && haystack.charAt(i) != needle.charAt(0)) {
                i++;
                modify = true;
            }
            if(modify) i--;
        }
        return -1;
    }
}
