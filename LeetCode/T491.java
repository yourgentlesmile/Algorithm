import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/increasing-subsequences
 *
 * DFS
 */
public class T491 {
    /**
     *
     * 递归枚举子序列的模板
     * List<List<Integer>> ans = new ArrayList<List<Integer>>();
     * List<Integer> temp = new ArrayList<Integer>();
     * public void dfs(int cur, int[] nums) {
     *     if (cur == nums.length) {
     *         // 判断是否合法，如果合法判断是否重复，将满足条件的加入答案
     *         if (isValid() && notVisited()) {
     *             ans.add(new ArrayList<Integer>(temp));
     *         }
     *         return;
     *     }
     *     // 如果选择当前元素
     *     temp.add(nums[cur]);
     *     dfs(cur + 1, nums);
     *     temp.remove(temp.size() - 1);
     *     // 如果不选择当前元素
     *     dfs(cur + 1, nums);
     * }
     */
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        /**
         * cur: 当前访问点位
         * last：上一个元素的值
         */
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        /**
         * 这里有两点考量：
         * 1、现在的元素要大于之前的元素，才能被选择
         * 2、这个>= 中的 = 则表示的是，遇到与前面相同的元素时，选择后者
         * 比如 0,1,1,1 ,递增子序列0,1只能出现一次，那这个 = 的目的最终就是选择最后一个1来作为0,1序列的构成
         */
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}
