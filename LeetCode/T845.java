/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 *
 */
public class T845 {
    public int longestMountain(int[] A) {
        int start = -1;
        int ans = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) { // 总是在上升阶段，确定山脉起点 start
                if (i == 1 || A[i - 2] >= A[i - 1]) {
                    start = i - 1;
                }
            } else if (A[i - 1] > A[i]) {
                if (start != -1) {
                    ans = Math.max(ans, i - start + 1); // 总是在下降阶段，计算山脉长度
                }

            } else {
                start = -1; // 平缓期重置起点
            }
        }
        return ans;
    }
}
