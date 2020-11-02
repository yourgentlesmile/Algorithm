import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 */
public class T349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums1) {
            s.add(i);
        }
        Set<Integer> j = new HashSet<>();
        for (int i : nums2) {
            j.add(i);
        }
        s.retainAll(j);
        int[] res = new int[s.size()];
        int index = 0;
        for (Integer integer : s) {
            res[index++] = integer;
        }
        return res;
    }
}
