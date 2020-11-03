/**
 * https://leetcode-cn.com/problems/valid-mountain-array/
 *
 * 两遍扫描
 * 第一遍从左往右找最高点
 * 第二遍从右往左找最高点
 */
public class T941 {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        boolean reachTop = false;
        boolean hasLeft = false;
        for (int i = 1; i < A.length; i++) {
            if(A[i - 1] == A[i]) return false;
            if(reachTop) {
                if(A[i - 1] < A[i]) {
                    return false;
                }
            }else {
                if(A[i - 1] > A[i]) {
                    reachTop = true;
                }else {
                    hasLeft = true;
                }
            }
        }
        return reachTop && hasLeft;
    }
}
