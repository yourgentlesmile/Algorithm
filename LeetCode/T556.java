import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-greater-element-iii
 *
 * 先找到前一位大于后一位的数字
 * 然后再寻找那个数字之后的数字，找到比他大又最接近的数子进行交换，然后将
 * 这个区段排序即可
 */
public class T556 {
    public int nextGreaterElement(int n) {
        if(n < 10) return -1;
        char[] c = String.valueOf(n).toCharArray();
        int l = c.length - 2;
        boolean modify = false;
        while (l >= 0) {
            if(c[l] < c[l + 1]) {
                int i = c.length - 1;
                for(;i > l;i--) {
                    if(c[i] > c[l]) break;
                }
                modify = true;
                char t = c[l];
                c[l] = c[i];
                c[i] = t;
                Arrays.sort(c,l + 1,c.length);
                break;
            }
            l--;
        }
        if(!modify) return -1;
        try {
            return Integer.parseInt(new String(c));
        } catch (Exception e) {
            return -1;
        }
    }
}
