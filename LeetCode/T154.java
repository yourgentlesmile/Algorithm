/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class T154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right = right - 1;
        }
        return nums[left];
    }
}
