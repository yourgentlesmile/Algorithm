/**
 * https://leetcode-cn.com/problems/maximum-subarray
 *
 * 动态规划，dp[i] = max(dp[i - 1] + nums[i], nums[i])
 */
public class T53 {
    public int maxSubArray(int[] nums) {
        int max = -100;
        int prev = 0;
        int cur = nums[0];
        for(int c : nums) {
            prev = Math.max(c + prev, c);
            max = Math.max(prev,max);
        }
        return max;
    }
}
