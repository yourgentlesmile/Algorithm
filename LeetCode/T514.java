import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/freedom-trail
 *
 * 记忆化搜索
 */
public class T514 {
    char[] r;
    char[] k;
    HashMap<Character, List<Integer>> indexMap;
    int[][] cache;
    public int findRotateSteps(String ring, String key) {
        r = ring.toCharArray();
        k = key.toCharArray();
        indexMap = new HashMap<>();
        cache = new int[r.length][k.length];
        for(int[] x : cache) {
            Arrays.fill(x, -1);
        }
        for (int i = 0; i < r.length; i++) {
            List<Integer> idx = indexMap.getOrDefault(r[i], new ArrayList<>());
            idx.add(i);
            indexMap.put(r[i], idx);
        }
        return k.length + dfs(0, 0);
    }

    /**
     * @param ringi 当前指针位置(指向12：00的字符的索引)
     * @param keyi 期望转移到的字符索引
     * @return keyi 字符开始一直拼成 key末尾所需要的最小步骤
     */
    public int dfs(int ringi, int keyi) {
        if(keyi == k.length) {
            return 0;
        }
        if(cache[ringi][keyi] != -1) {
            return cache[ringi][keyi];
        }
        char cur = k[keyi];
        int res = Integer.MAX_VALUE;
        List<Integer> arr = indexMap.get(cur);
        for (Integer targeti : arr) {
            int distance1 = Math.abs(ringi - targeti); //直接转移距离
            int distance2 = r.length - distance1;   //另一个方向的转移距离
            int curmin = Math.min(distance1, distance2);
            res = Math.min(res, curmin + dfs(targeti, keyi + 1)); //当前步数 + 下一个状态的步数
        }
        cache[ringi][keyi] = res;
        return res;
    }
}
