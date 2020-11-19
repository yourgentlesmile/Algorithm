/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 */
public class T283 {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        int write = 0;
        int c = 0;
        while(nonZero < nums.length) {
            if(nums[nonZero] != 0) {
                nums[write++] = nums[nonZero];
                c++;
            }
            nonZero++;
        }
        for(int i = c; i < nums.length;i++) {
            nums[i] = 0;
        }
    }
}
