/**
 * https://leetcode-cn.com/problems/add-strings/submissions/
 */
public class T415 {
    public String addStrings(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        StringBuilder res = new StringBuilder();
        int l = s1.length - 1;
        int r = s2.length - 1;
        int carry = 0;
        while(l >= 0 || r >= 0) {
            int n = 0;
            int m = 0;
            if(l >= 0) {
                n = s1[l] - '0';
                l--;
            }
            if(r >= 0) {
                m = s2[r] - '0';
                r--;
            }
            res.append((n + m + carry) % 10);
            carry = (n + m + carry) / 10;

        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
