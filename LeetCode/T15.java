import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 先将数据进行排序，之后从左往右遍历数组，直到遍历到大于0时即可返回数据
 */
public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> set = new ArrayList<>();
        if(nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3;i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1;
                int r = nums.length - 1;
                int sum = -nums[i];
                while(l < r) {
                    if(nums[i] > 0) return set;
                    if(nums[l] + nums[r] == sum) {
                        set.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        //如果下一个元素与当前元素相同时，则跳过下一个元素，
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        while(l < r && nums[r] == nums[r - 1]) r--;

                        l++;
                        r--;
                    } else if(nums[i] + nums[l] + nums[r] > 0) r--; //表示右边的元素过大，需要进行左移
                    else l++;
                }
            }
        }
        return set;
    }
}
