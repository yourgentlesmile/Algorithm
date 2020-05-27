/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number
 * Floyd判圈算法，快慢指针
 */
public class T287 {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length < 2) return -1;
        int fast = 0;
        int slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(nums[fast] != nums[slow]);
        slow = 0;
        while(nums[fast] != nums[slow]) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return nums[fast];
    }
}
