/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2020/4/1 17:52.
 */
public class T1111 {
    public static int[] maxDepthAfterSplit(String seq) {
        char[] chars = seq.toCharArray();
        int[] ans = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ans[i] = chars[i] == '(' ? i & 1 : ((i + 1) & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String as = "((()()))";
        maxDepthAfterSplit(as);
    }
}
