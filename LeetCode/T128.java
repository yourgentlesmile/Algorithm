import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 也可以使用并查集
 */
public class T128 {
    /**
     * 这不符合题目要求的O(n)时间复杂度
     */
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        if(nums.length == 1) return 1;
        int[] ints = Arrays.stream(nums).distinct().sorted().toArray();
        int max = 0;
        int counter = 0;
        int prev = ints[0] - 1;
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] - prev == 1) {
                counter++;
                prev = ints[i];
            }
            else {
                max = Math.max(counter, max);
                counter = 0;
                prev = ints[i] - 1;
                i -= 1;
            }
        }
        return Math.max(counter, max);
    }

    /**
     * 使用Hash表来判断数字 + 1 是否存在，如果存在则继续查询
     * 优化点：例如100,4,200,1,3,2
     * 4其实是不用进行递归查询的，因为4它的前继数字存在，所以在之后的遍历中会回来访问
     * 所以对于前继存在的数字，可以直接跳过
     */
    public static int answer(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if(!set.contains(num - 1)) {
                int cur = num + 1;
                int counter = 0;
                while (set.contains(cur)) {
                    counter++;
                    cur++;
                }
                max = Math.max(max, counter);
            }
        }
        return max + 1;
    }
}
