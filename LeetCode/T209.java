/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 双指针
 */
public class T209 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null ||  nums.length == 0) return 0;
        int l = 0;
        int r = 0;
        int sum = nums[l];
        int len = Integer.MAX_VALUE;
        while(l <= r) {
            if(sum < s) {
                r++;
                if(r >= nums.length) break;
                sum += nums[r];
            }else{
                len = Math.min(len, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
