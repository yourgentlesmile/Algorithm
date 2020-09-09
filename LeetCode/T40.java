import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * 回溯
 */
public class T40 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> cache = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }
    public void backtrack(int[] arr, int start,int expect) {
        if(expect == 0) {
            res.add(new ArrayList<>(cache));
            return;
        }
        for(int i = start; i < arr.length; i++) {
            if(expect - arr[i] < 0) return;
            if(i > start && arr[i - 1] == arr[i]) {
                continue;
            }
            cache.add(arr[i]);
            backtrack(arr, i + 1, expect - arr[i]);
            cache.removeLast();
        }
    }
}
