/**
 * https://leetcode-cn.com/problems/magic-index-lcci/
 *
 * 可以使用二分
 */
public class MT0803 {
    public int findMagicIndex(int[] nums) {
        if(nums.length == 0) return -1;
        int index = Math.max(nums[0], 0);
        while(index < nums.length) {
            if(index != nums[index]) {
                if(nums[index] < 0) {
                    index++;
                } else {
                    index = nums[index];
                }
            } else {
                return index;
            }
        }
        return -1;
    }
}
