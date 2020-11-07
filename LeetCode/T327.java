/**
 * https://leetcode-cn.com/problems/count-of-range-sum/
 *
 * 此题可以使用线段树，树状数组来解决，
 * 详情看力扣题解
 *
 * https://leetcode-cn.com/problems/count-of-range-sum/solution/qu-jian-he-de-ge-shu-by-leetcode-solution/
 *
 * https://leetcode-cn.com/problems/count-of-range-sum/solution/xian-ren-zhi-lu-ru-he-xue-xi-ke-yi-jie-jue-ben-ti-/
 */
public class T327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (lower <= sum && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
}
