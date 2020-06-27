/**
 * https://leetcode-cn.com/problems/first-missing-positive
 * 由题意可知，答案一定在1~N中，N = 数组长度
 *
 * 所以通过负数标记的方式来找出缺失的值
 *
 * 1、首先先将小于0的数字替换为大于数组长度的数字
 * 2、再遍历数组，根据值来将相应位置的数字置为负数，表示这个位置下标的数字出现过
 * 3、再次遍历数组，只要发现该位置的数组是大于0的，则表示该位置下标的数组未曾出现在
 *    原始数组中，则答案就是该下标 + 1
 *
 */
public class T41 {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int c = Math.abs(nums[i]) - 1;
            if(c < nums.length) {
                nums[c] = Math.abs(nums[c]) * -1;
            }
        }
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }
}
