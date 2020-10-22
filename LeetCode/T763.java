import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 *
 * 贪心算法
 */
public class T763 {
    public List<Integer> partitionLabels(String S) {
        char[] s = S.toCharArray();
        int[] res = new int[S.length()];
        for(int i = 0;i < s.length;i++) {
            res[i] = i;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length;i++) {
            if(map.containsKey(s[i])) {
                int start = map.get(s[i]);
                for(int j = start;j <= i;j++) {
                    res[j] = start;
                    map.put(s[j],start);
                }
            }else {
                map.put(s[i],i);
            }
        }
        int c = 0;
        int m = res[0];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            if(res[i] == m) c++;
            else {
                list.add(c);
                m = res[i];
                c = 1;
            }
        }
        list.add(c);
        return list;
    }
    public List<Integer> bestAnswer(String S) {
        int[] c = new int[26];
        char[] s = S.toCharArray();
        //一次遍历，获得每个字符最后出现的下标
        for(int i = 0;i < c.length;i++) {
            c[s[i] - 'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> list = new ArrayList<>();
        //第二次遍历，由于end变量会保存到遍历字符的最后出现位置的最大值
        //所以当end == i(当前遍历位置)时，可以确保，这个区间内的所有种类的字符都只在这个区间里
        //因此可以将这个区间划分为一个答案区间
        for (int i = 0; i < s.length; i++) {
            end = Math.max(end, c[s[i] - 'a']);
            if(i == end) {
                list.add(end -start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
