import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class T350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] lower = nums1.length > nums2.length ? nums2 : nums1;
        int[] higher = lower == nums1 ? nums2 : nums1;
        for (int i : lower) {
            int t = map.getOrDefault(i, 0);
            map.put(i, t + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : higher) {
            int t = map.getOrDefault(i, 0);
            if(t == 0) continue;
            res.add(i);
            map.put(i, t - 1);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
