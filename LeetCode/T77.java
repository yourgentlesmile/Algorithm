import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 *
 * 回溯
 */
public class T77 {
    int depth = 1;
    List<Integer> cache = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        depth = k;
        backtrack(1, n, 1);
        return res;
    }
    public void backtrack(int start, int n ,int d) {
        if(d > depth) return;
        for(int i = start;i <= n;i++) {
            cache.add(i);
            if(d == depth) res.add(new ArrayList<>(cache));
            else backtrack(i + 1, n, d + 1);
            cache.remove(cache.size() - 1);
        }
    }
}
