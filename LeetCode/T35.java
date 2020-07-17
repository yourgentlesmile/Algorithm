/**
 * https://leetcode-cn.com/problems/search-insert-position
 *
 * 二分查找
 */
public class T35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length - 1;
        int left = 0;
        int right = len;
        int mid = right / 2;
        while(left < right) {
            if(target > nums[mid]) {
                left = mid + 1;
            } else if(target == nums[mid]){
                return mid;
            }else {
                right = mid - 1;
            }
            mid = (right + left) / 2;
        }
        return nums[mid] < target ? mid + 1 : mid;
    }
}
