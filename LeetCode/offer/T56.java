package offer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * 分组思想，由于只有两个数字是出现一次
 * 并且，异或是相同为0，不同为1
 * 因此，全数组异或的结果，即为两个答案的异或结果，为1的位置是位不相同的地方
 * 分组思想就是，将相同的数字分在一组，答案分在不同组
 * 可以通过 res & -res,来快速求得能区分答案的最低位(mask)
 * 之后通过这个最低位来进行分组
 * 达到目的，因为相同数组，指定位的数字一定是一样的，所以一定会落入同一组
 *
 */
public class T56 {
    public int[] singleNumbers(int[] nums) {
        int res = nums[0];
        for(int i = 1;i < nums.length;i++) {
            res ^= nums[i];
        }
        int mask = res & -res;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}
