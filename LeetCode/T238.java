/**
 * https://leetcode-cn.com/problems/product-of-array-except-self
 * 通过前缀数组与后缀数组相乘进行求解
 * 空间优化：只需要一个数组即可，后缀数组可以用一个变量来存当前后缀的乘积，之后与
 * 前缀数组进行运算得到结果
 */
public class T238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length < 2) return nums;
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int R = 1;
        for (int i = len - 2; i >= 0; i--) {
            R = R * nums[i + 1];
            res[i] = R * res[i];
        }
        return res;
    }
}
