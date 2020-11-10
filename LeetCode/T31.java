/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * 从后往前寻找顺序对，顺序对头则是较小值
 * 再从扫过的区间从右往左寻找比较小值大的较大值，两者交换
 * 最后将较小值之后的区间做一次反转(因为这区间之前一定是降序区间，需要转换成升序区间，升序是数组的最小排列)
 */
public class T31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
