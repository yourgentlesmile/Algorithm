/**
 * https://leetcode-cn.com/problems/best-sightseeing-pair
 * A[i] + A[j] + i - j
 * 可以理解为 A[i] + i   +   A[j] - j
 * 由于A[j] - j是固定的(在计算A[j]这个点所组成的答案时)，所以，只要前面的A[i] + i最大就行了
 * 用一个premax来维护前面的A[i] + i
 * 则答案就是premax +  A[j] - j
 */
public class T1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int premax = A[0];
        int ans = 0;
        for(int i = 1;i < A.length;i++) {
            ans = Math.max(ans, premax + A[i] - i);
            premax = Math.max(premax, A[i] + i);
        }
        return ans;
    }
}
