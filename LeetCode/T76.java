/**
 * https://leetcode-cn.com/problems/minimum-window-substring
 */
public class T76 {
    public static void main(String[] args) {
        String s = minWindow("bba", "ab");
        System.out.println();
    }
    public static String minWindow(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int left = 0;
        int right = 0;
        int[] ori = new int[128];
        int[] cu = new int[128];
        for (char c : b) {
            ori[c]++;
        }
        int[] addr = new int[2];
        int maxlen = a.length + 1;
        int distance = 0;
        while(distance == b.length || right < a.length) {
            if(distance == b.length) {
                if((right - left) < maxlen) {
                    addr[0] = left;
                    addr[1] = right;
                    maxlen = right - left;
                }
                char l = a[left];
                if(cu[l] <= ori[l]) distance--;
                cu[l]--;
                left++;
            }else {
                char r = a[right];
                if(cu[r] < ori[r]) distance++;
                cu[r]++;
                right++;
            }
        }
        return s.substring(addr[0], addr[1]);
    }
}
