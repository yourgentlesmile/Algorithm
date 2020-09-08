import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * 回溯
 */
public class T39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cache = new LinkedList<>();
    int sum = 0;
    int expect = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        expect = target;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < candidates.length;i++) {
            list.add(candidates[i]);
        }
        backtrack(list, 0);
        return res;
    }
    public void backtrack(List<Integer> arr,int start) {
        if(sum == expect) {
            res.add(new ArrayList<>(cache));
            return;
        }
        for(int i = start; i < arr.size();i++) {
            int c = arr.get(i);
            sum += c;
            if(sum > expect) {
                sum -= c;
                return ;
            }
            cache.add(c);
            backtrack(arr, i);
            cache.remove(cache.size() - 1);
            sum -= c;
        }
    }
}
