import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 回溯
 */
public class T47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cache = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0);
        return res;
    }
    public void backTrack(int[] nums, int index) {
        if(index == nums.length) {
            res.add(new ArrayList(cache));
            return;
        }
        for(int i = 0; i < nums.length;i++) {
            Set<Integer> s = new HashSet<>();
            if(i > 0 && nums[i - 1] == nums[i])  continue;
            if(nums[i] == Integer.MAX_VALUE) continue;
            if(s.contains(nums[i])) {
                continue;
            }else {
                s.add(nums[i]);
            }
            cache.add(nums[i]);
            int c = nums[i];
            nums[i] = Integer.MAX_VALUE;
            backTrack(nums, index + 1);
            cache.remove(cache.size() - 1);
            nums[i] = c;
        }
    }
}
