/**
 * https://leetcode-cn.com/problems/house-robber
 * 动态规划
 * 转移方程为：对于当前i这座房子，可以选择抢于不抢
 * 抢：那收益 = 当前房子价值 + (i - 2)座房子为止的最高价值
 * 不抢：收益等于 到(i - 1)座房子为止的最高价值
 * 因此，关心的是i 之前的两座房子，所以只需要两个变量就行，不需要创建DP数组
 */
public class T198 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int fir = nums[0];
        int sec = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length;i++) {
            int tmp = Math.max(nums[i] + fir, sec);
            fir = sec;
            sec = tmp;
        }
        return sec;
    }
}
