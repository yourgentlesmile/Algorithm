import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 与T15相仿
 */
public class T16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0;i < nums.length - 2;i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if(sum > target) {
                    k--;
                }else if(sum < target){
                    j++;
                }else {
                    return sum;
                }
            }
        }
        return ans;
    }
}
