import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/relative-sort-array
 *
 */
public class T1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < arr2.length;i++) {
            map.putIfAbsent(arr2[i], i);
        }
        return Arrays.stream(arr1).boxed().sorted((x, y) -> {
            int left = 0;
            int right = 0;
            if(map.containsKey(x)) {
                left = map.get(x);
            }else {
                left = arr2.length + x;
            }
            if(map.containsKey(y)) {
                right = map.get(y);
            }else {
                right = arr2.length + y;
            }
            return left - right;
        }).mapToInt(x -> x).toArray();
    }
}
