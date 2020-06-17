/**
 * https://leetcode-cn.com/problems/single-number/
 * 直接全数字异或，由于相同数组异或会为0, 任意数字异或0等于他本身
 * 因此，全部异或一遍就为答案
 */
public class T136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1;i < nums.length;i++) {
            res ^= nums[i];
        }
        return res;
    }
}
