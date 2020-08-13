import java.util.ArrayList;
import java.util.Collections;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 * 模拟乘法操作。与字符串相加结合
 */
public class T43 {
    public String multiply(String num1, String num2) {
        char[] n1 = reverse(num1.toCharArray());
        char[] n2 = reverse(num2.toCharArray());
        if(n1.length == 1 && n1[0] - '0' == 0 || n2.length == 1 && n2[0] - '0' == 0) return "0";
        ArrayList<ArrayList<Character>> addCache = new ArrayList<>();
        for(int a = 0;a < n2.length;a++) {
            ArrayList<Character> list = new ArrayList<>();
            int carry = 0;
            int j = 0;
            while(j < a) {
                list.add('0');
                j++;
            }
            for(char i : n1) {
                int r = (n2[a] - '0') * (i - '0');
                list.add((char)('0' + (r + carry) % 10));
                carry = (r + carry) / 10;
            }
            if(carry != 0) list.add((char)('0' + carry));
            addCache.add(list);
        }
        char[] cache = new char[]{'0'};
        for(int i = 0 ; i < addCache.size();i++) {
            ArrayList<Character> characters = addCache.get(i);
            Collections.reverse(characters);
            char[] k = new char[characters.size()];
            for (int i1 = 0; i1 < k.length; i1++) {
                k[i1] = characters.get(i1);
            }
            cache = addStrings(cache, k);
        }
        return new String(cache);
    }
    public char[] addStrings(char[] num1, char[] num2) {
        char[] s1 = num1;
        char[] s2 = num2;
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
        return res.reverse().toString().toCharArray();
    }
    public static char[] reverse(char[] arr){
        for(int i = 0;i < arr.length / 2;i++){
            char temp = arr[arr.length -i - 1];
            arr[arr.length -i - 1] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
