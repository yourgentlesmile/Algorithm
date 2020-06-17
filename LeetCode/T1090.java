import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/largest-values-from-labels/
 * 本题先将values进行排序，从最大的开始选择(贪心)，选择时判断label是否符合要求
 * 如果符合，则加入答案，不符合则下一个
 */
public class T1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Pair<Integer, Integer>[] c = new Pair[values.length];
        for(int i = 0;i < values.length;i++) {
            c[i] = new Pair(values[i], labels[i]);
        }
        Arrays.sort(c, (x , y) -> (y.getKey() - x.getKey()));
        int res = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Pair<Integer, Integer> p : c) {
            map.putIfAbsent(p.getValue(), 1);
            if(map.get(p.getValue()) <= use_limit) {
                res += p.getKey();
                count++;
                map.put(p.getValue(),map.get(p.getValue()) + 1);
            }
            if(count == num_wanted) {
                break;
            }
        }
        return res;
    }
}
