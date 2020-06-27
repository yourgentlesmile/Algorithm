/**
 * https://leetcode-cn.com/problems/missing-number/
 * 与T41题类似
 */
public class T268 {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) {
                if(nums[i] == 0) hasZero = true;
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int c = Math.abs(nums[i]);
            if(c < nums.length) {
                nums[c] = Math.abs(nums[c]) * -1;
            }
        }
        for(int i = 0;i < nums.length;i++) {
            if(i == 0 && hasZero) continue;
            if(nums[i] > 0) return i;
        }
        return nums.length;
    }
}
