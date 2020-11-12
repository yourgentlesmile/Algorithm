/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 *
 */
public class T922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int odd = 0;
        int even = 1;
        for(int i : A) {
            if((i & 1) == 0) {
                res[odd] = i;
                odd += 2;
            }else {
                res[even] = i;
                even += 2;
            }
        }
        return res;
    }
}
