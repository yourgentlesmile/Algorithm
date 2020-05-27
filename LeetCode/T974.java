import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 前缀和与同余定理
 */
public class T974 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for(int c : A) {
            sum += c;
            int tmp = map.getOrDefault(((sum % K) + K) % K, 0);
            map.put(((sum % K) + K) % K, tmp + 1);
        }
        int ans = 0;
        for(Integer m : map.values()) {
            ans += (m * (m - 1)) / 2;
        }
        return ans;
    }
}
