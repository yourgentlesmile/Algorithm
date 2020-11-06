import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 *
 */
public class T1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted((o1, o2) -> {
            int count1 = Integer.bitCount(o1);
            int count2 = Integer.bitCount(o2);
            if (count1 == count2) {
                return o1 - o2;
            }
            return count1 - count2;
        }).mapToInt(val -> val).toArray();

    }
}
