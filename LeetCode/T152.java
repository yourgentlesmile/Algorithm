/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class T152 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length ==  0) return 0;
        int len = nums.length;
        int preMax = nums[0];
        int preMin = nums[0];
        int temp1 = 0;
        int temp2 = 0;
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            if(nums[i] >= 0) {
                temp1 = Math.max(nums[i], preMax * nums[i]);
                temp2 = Math.min(nums[i], preMin * nums[i]);
            } else {
                temp1 = Math.max(nums[i], preMin * nums[i]);
                temp2 = Math.min(nums[i], preMax * nums[i]);
            }
            ans = Math.max(ans, temp1);
            preMax = temp1;
            preMin = temp2;
        }
        return ans;
    }
}
