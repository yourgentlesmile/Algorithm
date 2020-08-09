import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/count-binary-substrings/
 *
 * 将连续的数组汇总成个数之后,由于相邻的集合所代表的数字肯定不一样
 * 能组成答案的个数就取决于两个集合中元素更少的那个集合里元素的个数
 * 例如：
 * 001110 -> 2 3 1 -> 2与3 组合，则能组合出的答案个数取决于2
 *
 * 即 00 与 111 组合 可以组成 0011  01
 */
public class T696 {
    public int countBinarySubstrings(String s) {
        List<Integer> r = new ArrayList<>();
        char prev = s.charAt(0);
        int count = 0;
        for(int i = 0 ;i < s.length();i++) {
            if(s.charAt(i) == prev) {
                count++;
            }else {
                r.add(count);
                count = 1;
            }
            prev = s.charAt(i);
        }
        r.add(count);
        int res = 0;
        for (int i = 1; i < r.size(); i++) {
            res += Math.min(r.get(i - 1),r.get(i));
        }
        return res;
    }
}
