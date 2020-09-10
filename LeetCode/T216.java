import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * 回溯
 */
public class T216 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> cache = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, n, k);
        return res;
    }

    public void backtrack(int start,int expect, int depth) {
        if(expect == 0 && depth == 0) {
            res.add(new ArrayList<>(cache));
            return;
        }
        for(int i = start; i < 10; i++) {
            if(expect - i < 0) return;
            if(expect - i != 0 && depth == 0) return;
            cache.add(i);
            backtrack(i + 1, expect - i, depth - 1);
            cache.removeLast();
        }
    }
}
