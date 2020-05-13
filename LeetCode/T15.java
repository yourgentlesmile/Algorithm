import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> set = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return new ArrayList<List<Integer>>();
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
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        while(l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if(nums[i] + nums[l] + nums[r] > 0) r--;
                    else l++;
                }
            }
        }
        return set;
    }
}
