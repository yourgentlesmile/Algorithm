import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/
 *
 * 通过维护一个小根堆来实现遍历
 * 操作类似于HBase在读取的时候，将不同类型的scanner放入了小根堆当中
 * 排序依据就是每个scanner seek到头的那个值
 */
public class T632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int l = 0;
        int r = Integer.MAX_VALUE;
        int[] next = new int[nums.size()];
        int max = Integer.MIN_VALUE;
        int minRange = r - l;
        PriorityQueue<Integer> q = new PriorityQueue<>((Comparator<Integer>) (index1, index2) -> nums.get(index1).get(next[index1]) - nums.get(index2).get(next[index2]));

        for (int i = 0; i < nums.size(); i++) {
            q.offer(i);
            max = Math.max(nums.get(i).get(0),max);
        }
        for(;;) {
            Integer minIndex = q.poll();
            int cur = max - nums.get(minIndex).get(next[minIndex]);
            if(cur < minRange) {
                l = nums.get(minIndex).get(next[minIndex]);
                r = max;
                minRange = cur;
            }
            next[minIndex]++;
            if(minIndex >= nums.get(minIndex).size()) {
                break;
            }
            q.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{l, r};
    }
}
