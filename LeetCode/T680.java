/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2020/5/19 9:37.
 */
public class T680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("cbbcc"));
    }
    public static boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int b = 0;
        char[] v = s.toCharArray();
        int e = v.length - 1;
        boolean canDelete = true;
        boolean exp = false;
        while(b < e) {
            if(v[b] == v[e]) {
                b++;
                e--;
            }else {
                boolean lflag = true;
                boolean rflag = true;
                for(int i = b,j = e - 1; i < e - 1;i++,j--) {
                    if(v[i] != v[j]) {
                        lflag = false;
                        break;
                    }
                }
                for(int i = b + 1,j = e; i < e;i++,j--) {
                    if(v[i] != v[j]) {
                        rflag = false;
                        break;
                    }
                }
                return lflag || rflag;
            }
        }
        return true;
    }
}
