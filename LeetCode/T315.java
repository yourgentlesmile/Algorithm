import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 *
 * 使用树状数组来维护小于当前数组的前缀和
 *
 * 使用离散化来避免开启过大的数组空间，排序后，将数组元素使用下标来进行映射
 */
public class T315 {
    private int tree[];
    public int lowbit(int x) {
        return x & -x;
    }
    public void update(int i ,int k) {
        while (i < tree.length) {
            tree[i] += k;
            i += lowbit(i);
        }
    }
    public int getSum(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= lowbit(i);
        }
        return res;
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        tree = new int[nums.length + 1];
        List<Integer> ans = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0;i--) {
            int index = Arrays.binarySearch(sorted, nums[i]) + 1;
            ans.add(getSum(index - 1));
            update(index,1);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        T315 b = new T315();
        List<Integer> integers = b.countSmaller(new int[]{5,2,6,1});
        System.out.println(integers.toString());
    }
}
