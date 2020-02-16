import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 使用manacher算法
 */
public class Five {
    public static String longestPalindrome(String s) {
        s = init(s);
        char[] chars = s.toCharArray();
        int[] q = new int[chars.length];
        int id = 0,mx = 0;
        for(int i = 1;i < s.length() - 1;i++) {
            if(mx > i) q[i] = Math.min(q[2 * id - i],mx - i);
            else q[i] = 1;
            for(;s.charAt(i + q[i]) == s.charAt(i - q[i]);q[i]++);
            if(q[i] + i > mx) {
                mx = q[i] + i;
                id = i;
            }
        }
        int loc = 0;
        int ans = 0;
        for(int i = 0;i < q.length;i++) {
            if(ans <= q[i]) {
                ans = q[i];
                loc = i;
            }
        }
        return s.substring(loc - ans + 1, loc + ans - 1).replaceAll("#","");
    }
    public static String init(String s) {
        StringBuilder newone = new StringBuilder("$#");
        for(int i = 0;i < s.length();i++) {
            newone.append(s.charAt(i));
            newone.append("#");
        }
        newone.append("*");
        return newone.toString();

    }
public static String bestAnswer(String s) {
    if (s == null || s.length() == 0) {
        return "";
    }
    //存储回文数的最左边和最右边坐标
    int[] range = new int[2];
    char[] str = s.toCharArray();
    for(int i = 0; i < s.length(); i++){
        i = findLongestMiddle(str, i, range);
    }
    return s.substring(range[0],range[1] + 1);
}

    public static int findLongestMiddle(char[] str, int low, int[] range){
        //左右坐标  查找中间部分
        int high = low;
        while(high < str.length - 1 && str[low] == str[high + 1]){
            high++;
        }

        //保存连续相等字符串的最后一个字符
        int ans = high;

        //从中间字符往两边扩散  low-1 到 high+1
        while(low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]){
            low--;
            high++;
        }

        //保存回文数的左边和右边坐标  并判断是否为最长的回文数
        if(high - low > range[1] - range[0]){
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
    }
}
