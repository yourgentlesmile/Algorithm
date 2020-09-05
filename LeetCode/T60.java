import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 *
 * 全排列
 */
public class T60 {
    char[] s;
    int p = 0;
    public String getPermutation(int n, int k) {
        s = new char[n];
        int sum = 1;
        List<Integer> arr = new ArrayList<>();
        for(int i = 1;i <= n; i++) {
            arr.add(i);
            sum *= i;
        }

        //which shard
        while(p != n) {
            int slice = sum / arr.size();
            sum /= arr.size();
            int shard = findShard(slice, k);
            s[p++] = (char) ('0' + arr.get(shard));
            arr.remove(shard);
            if(arr.size() == 1) {
                s[p] = (char) ('0' + arr.get(0));
                break;
            }
            k -= (slice * shard);
        }
        return new String(s);
    }
    public int findShard(int slice, int k) {
        int i = 0;
        int m = slice;
        while(m < k) {
            m += slice;
            i++;
        }
        return i;
    }
}
