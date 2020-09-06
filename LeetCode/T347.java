import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * hash表统计次数，小顶堆维护答案
 */
public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int c : nums) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry> queue = new PriorityQueue<>(Comparator.comparingInt(x -> (Integer) (x.getValue())));
        for(Map.Entry a : map.entrySet()) {
            if(queue.size() < k) queue.add(a);
            else if((Integer) queue.peek().getValue() < (Integer) a.getValue()){
                queue.poll();
                queue.add(a);
            }
        }
        int[] res = new int[k];
        int index= 0;
        for (Map.Entry entry : queue) {
            res[index++] = (Integer) entry.getKey();
        }
        return res;
    }
}
