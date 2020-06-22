import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/avoid-flood-in-the-city/
 *
 * 主要是要想到能用TreeSet来获取一个key的lowerkey或者higherkey
 */
public class T1488 {
    public static int[] avoidFlood(int[] rains) {
        Map<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int[] res = new int[rains.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < rains.length; i++) {
            if(rains[i] == 0) {
                set.add(i);
                continue;
            }
            res[i] = -1;
            if(map.containsKey(rains[i])) {
                if(set.size() != 0 && set.higher(map.get(rains[i])) != null && set.higher(map.get(rains[i])) < i) {
                    Integer v = set.higher(map.get(rains[i]));
                    res[v] = rains[i];
                    set.remove(v);
                    map.put(rains[i], i);
                }else {
                    return new int[]{};
                }
            }else {
                map.put(rains[i], i);
            }
        }
        return res;
    }
}
