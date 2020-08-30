/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class T557 {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] split = s.split(" ");
        for(int i = 0;i < split.length;i++) {
            split[i] = reverse(split[i]);
        }
        return String.join(" ",split);
    }
    public String reverse(String s) {
        int len = s.length();
        char[] tmp = new char[len];
        for(int i = len - 1;i >= 0;i--) {
            tmp[len - i - 1] = s.charAt(i);
        }
        return new String(tmp);
    }
}
